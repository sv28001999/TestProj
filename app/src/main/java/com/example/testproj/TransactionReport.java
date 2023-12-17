package com.example.testproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.testproj.models.Constants;
import com.example.testproj.models.TransactionAdapter;
import com.example.testproj.models.TransactionData;
import com.example.testproj.models.TransactionReqBody;
import com.example.testproj.models.UserDataResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TransactionReport extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<TransactionData.Datum> transactionListData = new ArrayList<>();
    private ApiInterface apiInterface;
    SharedPreferences sharedPreferences;
    private ProgressDialog progressDialog;
    LinearLayout nullTransaction;
    private EditText editTextSearch;
    String formattedDateTime;
    TransactionAdapter adapter;
    String userIdData;
    int pageNo = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private Boolean isScrolling = false;
    LinearLayoutManager layoutManager;
    String searchText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_report);

        recyclerView = findViewById(R.id.recyclerViewTransaction);
        nullTransaction = findViewById(R.id.transactionNull);
        editTextSearch = findViewById(R.id.editTextSearch);
        layoutManager = new LinearLayoutManager(this);
        transactionListData = new ArrayList<>();
        adapter = new TransactionAdapter(transactionListData, TransactionReport.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = RetrofitClient.getInstance();
        apiInterface = retrofit.create(ApiInterface.class);
        sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        userIdData = sharedPreferences.getString(Constants.SF_USER_ID, "NA");

        Toolbar toolbar = findViewById(R.id.myTrxnToolbar);

        // Set the custom Toolbar as the support action bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Transaction History");

        // Enable the "Up" button (back button) functionality
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Handle the "Up" button click to navigate to the previous page
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int currentItems = layoutManager.getChildCount();
                int totalItems = layoutManager.getItemCount();
                int scrollOutItems = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading() && !isLastPage()) {
                    if (isScrolling && (currentItems + scrollOutItems == totalItems)) {
                        Log.d("end page found", "true");
                        loadMoreItems();
                    }
                }
            }
        });

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                searchText = editTextSearch.getText().toString();
                adapter.clearList();
                pageNo = 1;
                fetchData(userIdData, pageNo, searchText);
            }
        });

        fetchData(userIdData, pageNo, searchText);
    }

    private void loadMoreItems() {
        if (!isLoading()) {
            pageNo++;
            fetchData(userIdData, pageNo, searchText);
        }
    }

    private void fetchData(String userId, int pageNo, String filterText) {
        showLoader();
        isLoading = true;
        LocalDateTime currentDateTime = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            formattedDateTime = currentDateTime.format(formatter);
        }

        TransactionReqBody transactionReqBody = new TransactionReqBody(userId, "2023-11-28 07:07:00", formattedDateTime, filterText, pageNo, 10);

        Call<TransactionData> call = apiInterface.getTransactionSummary(transactionReqBody);

        call.enqueue(new Callback<TransactionData>() {
            @Override
            public void onResponse(@NonNull Call<TransactionData> call, @NonNull Response<TransactionData> response) {
                if (response.isSuccessful()) {
                    nullTransaction.setVisibility(View.GONE);
                    TransactionData transactionData = response.body();

                    assert transactionData != null;
                    ArrayList<TransactionData.Datum> transactionList = transactionData.getData();
                    if (transactionList != null) {
                        transactionListData.addAll(transactionList);
                        adapter.notifyDataSetChanged();
                        isLoading = false;
                    }
                    dismissLoader();

                } else {
//                    Toast.makeText(TransactionReport.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    nullTransaction.setVisibility(View.VISIBLE);
                    dismissLoader();
                }
            }

            @Override
            public void onFailure(@NonNull Call<TransactionData> call, @NonNull Throwable t) {
                Log.d("isFailed", "True");
                isLoading = false;
                isLastPage = true;
                nullTransaction.setVisibility(View.VISIBLE);
                dismissLoader();
            }
        });
    }

    private void showLoader() {
        progressDialog = new ProgressDialog(TransactionReport.this);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
    }

    private void dismissLoader() {
        if (progressDialog != null && progressDialog.isShowing()) {
            Log.d("loader", "dismiss");
            progressDialog.dismiss();
        }
    }

    private boolean isLoading() {
        return isLoading;
    }

    private boolean isLastPage() {
        return isLastPage;
    }

}