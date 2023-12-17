package com.example.testproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testproj.models.Constants;
import com.example.testproj.models.PaymentReq;
import com.example.testproj.models.PaymentRes;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PaymentPage extends AppCompatActivity {

    EditText txtUpiId, txtAmount, txtDescription, txtcreditorName;
    TextView creditorName, txtTransactionError, txtAmountAfterTax;
    Button payButton;
    private ProgressDialog progressDialog;
    private ApiInterface apiInterface;
    private String sfUserId;
    private double userWalletBalance;
    private static final long TOTAL_DURATION = 3000;
    private static final long TICK_INTERVAL = 1000;
    private String upiString;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        txtAmount = findViewById(R.id.txtAmount);
        txtUpiId = findViewById(R.id.txtUpiId);
        txtDescription = findViewById(R.id.txtDescription);
//        txtAmountAfterTax = findViewById(R.id.txtAmountAfterTax);
        payButton = findViewById(R.id.payButton);
        txtcreditorName = findViewById(R.id.txtcreditorName);
        creditorName = findViewById(R.id.creditorName);
        txtTransactionError = findViewById(R.id.txtErrorTrnx);

        Retrofit retrofit = RetrofitClient.getInstance();
        apiInterface = retrofit.create(ApiInterface.class);

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        sfUserId = sharedPreferences.getString(Constants.SF_USER_ID, "NA");

        userWalletBalance = Double.parseDouble(Constants.walletBalance);

        Toolbar toolbar = findViewById(R.id.payToolbar);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Payment");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        if (Constants.IS_SCANNED) {
            upiString = Constants.SCANNED_TEXT;

            uri = Uri.parse(upiString);

            String beneficiaryAccount = uri.getQueryParameter("pa");
//            String transactionNote = uri.getQueryParameter("tn");
            String payerName = uri.getQueryParameter("pn");
            txtcreditorName.setText(payerName);
            txtUpiId.setText(beneficiaryAccount);
            if (upiString.contains("am")) {
                String amount = uri.getQueryParameter("am");
                if (amount == null)
                    Log.d("amount received", "null amount");
                else {
                    if (!amount.isEmpty() && Double.parseDouble(amount) > 0) {
                        txtAmount.setText(amount);
                        txtAmount.setEnabled(false);
//                    double enteredAmount = Double.parseDouble(txtAmount.getText().toString());
//                    String afterTaxAmount = Double.toString(enteredAmount + (enteredAmount * 5) / 100);
//                    txtAmountAfterTax.setText("₹" + afterTaxAmount + " will be deduct from your wallet");
                    }
                }
            }
            txtcreditorName.setEnabled(false);
            txtUpiId.setEnabled(false);
            txtcreditorName.setVisibility(View.VISIBLE);
            creditorName.setVisibility(View.VISIBLE);
        }

//        txtAmount.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (!txtAmount.getText().toString().isEmpty()) {
////                    double enteredAmount = Double.parseDouble(txtAmount.getText().toString());
////                    String afterTaxAmount = Double.toString(enteredAmount + (enteredAmount * 5) / 100);
////                    txtAmountAfterTax.setText("₹" + afterTaxAmount + " will be deduct from your wallet");
//                } else {
////                    txtAmountAfterTax.setText("₹0 will be deduct from your wallet");
//                }
//            }
//        });

        payButton.setOnClickListener(view -> {
            String refId = generateUniqueId();
            String amount = txtAmount.getText().toString();
            String upiId = txtUpiId.getText().toString();
            String remark = txtDescription.getText().toString();

//            if (upiString != null && upiString.contains("tr")) {
//                refId = uri.getQueryParameter("tr");
//            }

            if (validateFields(upiId, amount)) {
                showLoader();

                if (remark.isEmpty()) {
                    remark = Constants.DESCRIPTION_TEXT;
                }

                PaymentReq paymentReq = new PaymentReq(refId, upiId, amount, remark, sfUserId);
                Log.d("payment request user id", sfUserId);
                Call<PaymentRes> call = apiInterface.startUpiTranscation(paymentReq);

                call.enqueue(new Callback<PaymentRes>() {
                    @Override
                    public void onResponse(@NonNull Call<PaymentRes> call, @NonNull Response<PaymentRes> response) {
                        if (response.isSuccessful()) {
                            // Login successful, handle the response
                            PaymentRes paymentRes = response.body();
                            assert paymentRes != null;
//                            String resMessage = paymentRes.getMessage();
                            boolean resStatus = paymentRes.getStatus();
                            Log.d("Payment Status", resStatus + "   " + paymentRes.getStatus());
                            if (resStatus && paymentRes.getStatuscode() == 200) {
                                startActivity(new Intent(getApplicationContext(), PaymentSuccess.class));
                                finish();
                            } else {
                                startTimer(TOTAL_DURATION);
                            }
                            dismissLoader();
                        } else {
                            dismissLoader();
                            startTimer(TOTAL_DURATION);
                            Log.d("response failed", "failed");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<PaymentRes> call, @NonNull Throwable t) {
                        // Handle network or other failures
                        // For example, show a network error message
                        dismissLoader();
                        Toast.makeText(PaymentPage.this, "Please check you Internet Connectivity..", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public static String generateUniqueId() {
        // Get current timestamp in milliseconds
        long timestamp = System.currentTimeMillis();

        // Generate a random number
        int randomNum = (int) (Math.random() * 1000);

        return timestamp + "_" + randomNum;
    }

    private boolean validateFields(String upiId, String amount) {
        // Validate UPI ID
        if (upiId.isEmpty()) {
//            Toast.makeText(this, "Please enter UPI ID", Toast.LENGTH_SHORT).show();
            txtUpiId.setError("Please enter UPI ID");
            return false;
        }

        // Validate Amount
        if (amount.isEmpty()) {
//            Toast.makeText(this, "Please enter Amount", Toast.LENGTH_SHORT).show();
            txtAmount.setError("Please enter Amount");
            return false;
        }
//        else if (isInsufficientBalance(Double.parseDouble(amount))) {
//            txtTransactionError.setText("Insufficient Balance");
//            Toast.makeText(this, "Insufficient Balance", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        if (!isNetworkAvailable()) {
            Toast.makeText(this, "Network Issue...", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

    private boolean isInsufficientBalance(double withdrawAmount) {
        double usdtAmount = convertToUSDT(withdrawAmount);
        return (usdtAmount + (usdtAmount / 10)) > userWalletBalance;
    }

    private double convertToUSDT(double convertAmount) {
        return convertAmount / 90;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Constants.IS_SCANNED = false;
        txtcreditorName.setVisibility(View.GONE);
        creditorName.setVisibility(View.GONE);
        Log.e("onStop", "Called");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        txtcreditorName.setVisibility(View.GONE);
        creditorName.setVisibility(View.GONE);
        Constants.IS_SCANNED = false;
    }

    private void showLoader() {
        progressDialog = new ProgressDialog(PaymentPage.this);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
    }

    private void dismissLoader() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    private void startTimer(long totalDuration) {
        new CountDownTimer(totalDuration, TICK_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timer text with remaining seconds
                txtTransactionError.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                // Ensure the timer text displays 0s at the end
                txtTransactionError.setVisibility(View.GONE);
            }
        }.start();
    }
}