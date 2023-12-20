package com.example.testproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testproj.models.Constants;
import com.example.testproj.models.DashBoardRes;
import com.example.testproj.models.UserDataRequestBody;
import com.example.testproj.models.UserDataResponseBody;
import com.example.testproj.models.WalletBalanceResponse;
import com.google.android.material.navigation.NavigationView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePage extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private TextView tvFullName, tvWalletBalance, tvNavFullName, tvJrcBalance;
    private String userId, loginToken;
    private SharedPreferences sharedPreferences;
    private ApiInterface apiInterface;
    private ProgressDialog progressDialog;
    private ViewPager viewPager;
    private final int[] images = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
    };
    private int currentPage = 0;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ImageView profileIcon = findViewById(R.id.menuBtn);
        LinearLayout prepaidBtn = findViewById(R.id.prepaidBtn);
        LinearLayout postpaidBtn = findViewById(R.id.postpaidBtn);
        LinearLayout dthBtn = findViewById(R.id.dthBtn);
        LinearLayout gasBtn = findViewById(R.id.gasBtn);
        LinearLayout waterBtn = findViewById(R.id.waterBtn);
        LinearLayout dataBtn = findViewById(R.id.datacardBtn);
        LinearLayout electricityBtn = findViewById(R.id.electricityBtn);
        LinearLayout billBtn = findViewById(R.id.billBtn);
        LinearLayout fundBtn = findViewById(R.id.fundBtn);
        LinearLayout busBtn = findViewById(R.id.busBtn);
        LinearLayout flightBtn = findViewById(R.id.flightBtn);
        LinearLayout hotelBtn = findViewById(R.id.hotelBtn);
        LinearLayout upiIdBtn = findViewById(R.id.upiIdBtn);
        LinearLayout scannerBtn = findViewById(R.id.scannerBtn);
        ImageView logoutBtn = findViewById(R.id.logoutBtnIcn);
        LinearLayout balanceSummaryBtn = findViewById(R.id.balanceSummaryBtn);
        LinearLayout payCryptoBtn = findViewById(R.id.payCryptoBtn);
        LinearLayout parkCryptoBtn = findViewById(R.id.parkCryptoBtn);
        LinearLayout convertCryptoBtn = findViewById(R.id.convertCryptoBtn);
        LinearLayout withdrawCryptoBtn = findViewById(R.id.withdrawCryptoBtn);
        LinearLayout swapeCryptoBtn = findViewById(R.id.swapeCryptoBtn);
        LinearLayout saleCryptoBtn = findViewById(R.id.saleCryptoBtn);
        LinearLayout purchaseCryptoBtn = findViewById(R.id.purchaseCryptoBtn);
        LinearLayout bankTransferBtn = findViewById(R.id.bankTransferBtn);
        LinearLayout jrcBtn = findViewById(R.id.jrcBtn);
        tvFullName = findViewById(R.id.tvFullName);
        tvWalletBalance = findViewById(R.id.tvWalletBalance);
        tvNavFullName = findViewById(R.id.tvNavFullName);
        tvJrcBalance = findViewById(R.id.tvJrcBalance);
        View headerView = navigationView.getHeaderView(0);
        tvNavFullName = headerView.findViewById(R.id.tvNavFullName);

//        Log.d("user id home", Constants.SF_USER_ID);

        viewPager = findViewById(R.id.viewPager);
        ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == images.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 2000, 3000); // Delay 2000ms, repeat every 3000ms

        sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        userId = sharedPreferences.getString(Constants.SF_USER_ID, "NA");
        loginToken = sharedPreferences.getString(Constants.LOGIN_TOKEN, "NA");
        Log.d("authToken1", loginToken);

        Retrofit retrofit = RetrofitClient.getInstance();
        apiInterface = retrofit.create(ApiInterface.class);

        prepaidBtn.setOnClickListener(view -> navigateCommingSoon());
        postpaidBtn.setOnClickListener(view -> navigateCommingSoon());
        dthBtn.setOnClickListener(view -> navigateCommingSoon());
        gasBtn.setOnClickListener(view -> navigateCommingSoon());
        waterBtn.setOnClickListener(view -> navigateCommingSoon());
        dataBtn.setOnClickListener(view -> navigateCommingSoon());
        electricityBtn.setOnClickListener(view -> navigateCommingSoon());
        billBtn.setOnClickListener(view -> navigateCommingSoon());
        busBtn.setOnClickListener(view -> navigateCommingSoon());
        fundBtn.setOnClickListener(view -> navigateCommingSoon());
        flightBtn.setOnClickListener(view -> navigateCommingSoon());
        hotelBtn.setOnClickListener(view -> navigateCommingSoon());
        bankTransferBtn.setOnClickListener(view -> startActivity(new Intent(this, BankTransfer.class)));
        payCryptoBtn.setOnClickListener(view -> navigateCommingSoon());
        parkCryptoBtn.setOnClickListener(view -> navigateCommingSoon());
        purchaseCryptoBtn.setOnClickListener(view -> navigateCommingSoon());
        swapeCryptoBtn.setOnClickListener(view -> navigateCommingSoon());
        withdrawCryptoBtn.setOnClickListener(view -> navigateCommingSoon());
        saleCryptoBtn.setOnClickListener(view -> navigateCommingSoon());
        convertCryptoBtn.setOnClickListener(view -> navigateCommingSoon());
        balanceSummaryBtn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), TransactionReport.class));
        });
        jrcBtn.setOnClickListener(view -> navigateCommingSoon());
        profileIcon.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
        scannerBtn.setOnClickListener(view -> {
//            startBarcodeScanner();
            startActivity(new Intent(getApplicationContext(), ScannerActivity.class));
        });
        upiIdBtn.setOnClickListener(view -> startActivity(new Intent(HomePage.this, PaymentPage.class)));
        logoutBtn.setOnClickListener(view -> showLogoutDialog());

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_my_profile) {
                startActivity(new Intent(HomePage.this, Profile.class));
            }
//            else if (id == R.id.nav_portfolio) {
//                startActivity(new Intent(HomePage.this, Portfolio.class));
//            }
//            else if (id == R.id.nav_terms_of_service) {
//                // Handle Terms of Service click
//            }
            else if (id == R.id.nav_log_out) {
                showLogoutDialog();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        refreshUserDetail();
    }

    public void refreshUserDetail() {
        showLoader();
//        UserDataRequestBody userDataRequestBody = new UserDataRequestBody(requestUserId);

        Call<DashBoardRes> call = apiInterface.getDashboardData("Bearer " + loginToken);

        call.enqueue(new Callback<DashBoardRes>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<DashBoardRes> call, @NonNull Response<DashBoardRes> response) {
                if (response.isSuccessful()) {
                    // Login successful, handle the response
                    // You can navigate to the next screen or perform other actions here
                    DashBoardRes userDataResponseBody = response.body();
                    Log.d("statusType", userDataResponseBody.getStatusType());
                    assert userDataResponseBody != null;
                    if (userDataResponseBody.statusCode == 200 && Objects.equals(userDataResponseBody.statusType, "S")) {
                        tvFullName.setText(userDataResponseBody.getData().getFullName());
                        tvNavFullName.setText(userDataResponseBody.getData().getFullName());
                        Constants.walletBalance = userDataResponseBody.getData().getWalletBalance();
                        tvWalletBalance.setText("JRC " + Constants.walletBalance);
//                    getWalletInfo();
                        DecimalFormat df = new DecimalFormat("0.00");
                        String formattedAmount = df.format(userDataResponseBody.getData().getWalletBalance() * 90);
                        tvJrcBalance.setText("[₹" + formattedAmount + "]");
                        Log.d("Response", "Success");
                        dismissLoader();
                        saveData(userDataResponseBody);
                    } else {
                        startActivity(new Intent(HomePage.this, LoginPage.class));
                    }
                } else {
                    // Handle the API error
                    // For example, show an error message to the user
                    dismissLoader();
                    Log.d("response failed", "failed");
                }
            }

            private void getWalletInfo() {
                Call<WalletBalanceResponse> call = apiInterface.getWalletBalance("suvidha");

                call.enqueue(new Callback<WalletBalanceResponse>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(@NonNull Call<WalletBalanceResponse> call, @NonNull Response<WalletBalanceResponse> response) {
                        WalletBalanceResponse walletBalanceResponse = response.body();
                        assert walletBalanceResponse != null;
                        tvWalletBalance.setText("JRC " + walletBalanceResponse.getBalance());
                        tvJrcBalance.setText("[$" + walletBalanceResponse.getBalance() + "]");
                    }

                    @Override
                    public void onFailure(@NonNull Call<WalletBalanceResponse> call, @NonNull Throwable t) {
                        dismissLoader();
                        Toast.makeText(HomePage.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<DashBoardRes> call, @NonNull Throwable t) {
                // Handle network or other failures
                // For example, show a network error message
                dismissLoader();
                Toast.makeText(HomePage.this, "Please check you Internet Connectivity..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveData(DashBoardRes dataResponseBody) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.SF_FULL_NAME, dataResponseBody.getData().getFullName());
        editor.putString(Constants.SF_EMAIL, dataResponseBody.getData().getEmailId());
        editor.putString(Constants.SF_MOBILE, dataResponseBody.getData().getMobileNo());
        editor.putString(Constants.SF_JOINING_DATE, dataResponseBody.getData().getJoiningDate());
        editor.apply();
    }

    public void navigateCommingSoon() {
        startActivity(new Intent(this, CommingSoon.class));
    }

    private void startBarcodeScanner() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(true); // Lock the orientation
        integrator.setCaptureActivity(CustomScannerActivity.class); // Use a custom activity for horizontal orientation
        integrator.setPrompt("Scan a barcode");
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String scannedResult = result.getContents();
//                resultTextView.setText("Scanned Result: " + scannedResult);
                Constants.SCANNED_TEXT = scannedResult;
                Constants.IS_SCANNED = true;
                startActivity(new Intent(getApplicationContext(), PaymentPage.class));
                Log.e("Barcode Text", scannedResult);
//                finish();
            } else {
//                resultTextView.setText("Scan canceled");
                Log.e("Barcode Text", "Scan Cancelled");
            }
        }
    }

    private void showLoader() {
        progressDialog = new ProgressDialog(HomePage.this);
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

    public void logoutPage() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.SF_USER_ID, "NA");
        editor.putString(Constants.SF_LOGIN_ID, "NA");
        editor.putString(Constants.LOGIN_TOKEN, "NA");
        editor.putBoolean(Constants.IS_LOGGED_IN, false);
        editor.apply();
        startActivity(new Intent(HomePage.this, LoginPage.class));
        finish();
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.logout_dialog, null);

        builder.setView(dialogView);

        Button confirmLogoutBtn = dialogView.findViewById(R.id.confirmLogoutBtn);
        Button cancelLogoutBtn = dialogView.findViewById(R.id.cancelLogoutBtn);

        final AlertDialog exitDialog = builder.create();

        confirmLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle exit action here
                logoutPage();
            }
        });

        cancelLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitDialog.dismiss(); // Dismiss the dialog if Cancel button is clicked
            }
        });

        exitDialog.show();
    }

    private class ImagePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View itemView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.image_item, container, false);
            ImageView imageView = itemView.findViewById(R.id.imageView);
            imageView.setImageResource(images[position]);
            container.addView(itemView);
            return itemView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        refreshUserDetail();
    }
}