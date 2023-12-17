package com.example.testproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testproj.models.Constants;
import com.example.testproj.models.LoginRequestBody;
import com.example.testproj.models.LoginResponse;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginPage extends AppCompatActivity {

    Button loginBtn;
    TextView forgetPasswordBtn, registrationBtn, tvInvalidMsg;
    EditText txtUsername, txtPassword;
    private ApiInterface apiInterface;
    private SharedPreferences sharedPreferences;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginBtn = findViewById(R.id.loginBtn);
        forgetPasswordBtn = findViewById(R.id.forgetPasswordBtn);
        registrationBtn = findViewById(R.id.registrationBtn);
        txtUsername = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        tvInvalidMsg = findViewById(R.id.tvInvalidMsg);

        Retrofit retrofit = RetrofitClient.getInstance();
        apiInterface = retrofit.create(ApiInterface.class);

        sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(Constants.IS_LOGGED_IN, false);
        if (isLoggedIn) {
            startActivity(new Intent(getApplicationContext(), HomePage.class));
            finish();
        }

        loginBtn.setOnClickListener(view -> {
            showLoader();
            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();
            if (!username.isEmpty() && !password.isEmpty()) {
                checkUserLogin(username, password);
            } else {
                dismissLoader();
                tvInvalidMsg.setText(R.string.invalid_user_id_password);
                tvInvalidMsg.setVisibility(View.VISIBLE);
            }
        });

        forgetPasswordBtn.setOnClickListener(view -> {
            Intent intent = new Intent(LoginPage.this, WebviewActivity.class);
            intent.putExtra("navigate_url", Constants.FORGET_PASS_URL);
            intent.putExtra("title", "Forget Password");
            startActivity(intent);
        });

        registrationBtn.setOnClickListener(view -> {
            Intent intent = new Intent(LoginPage.this, WebviewActivity.class);
            intent.putExtra("navigate_url", Constants.REG_URL);
            intent.putExtra("title", "Register Account");
            startActivity(intent);
        });
    }

    public void checkUserLogin(String username, String password) {
        String ipAddress = getDeviceIPAddress();
        String storedIPAddress = "NA";
        if (ipAddress != null) {
            storedIPAddress = ipAddress;
            Log.e("IP Address", storedIPAddress);
        }

        LoginRequestBody loginRequestBody = new LoginRequestBody(username, password, storedIPAddress, "/Account/Login", 0);

        Call<LoginResponse> call = apiInterface.login(loginRequestBody);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    // Login successful, handle the response
                    LoginResponse loginResponse = response.body();
                    assert loginResponse != null;
                    if (loginResponse.status) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(Constants.SF_USER_ID, loginResponse.getData().getUserId());
                        editor.putString(Constants.SF_LOGIN_ID, loginResponse.getData().getLoginId());
                        editor.apply();
                        Intent intent = new Intent(LoginPage.this, OTPVerificationActivity.class);
                        intent.putExtra("LOGIN_EMAIL", loginResponse.getData().getEmailId());
                        intent.putExtra("LOGIN_OTP", loginResponse.getData().getOtp());
                        dismissLoader();
                        startActivity(intent);
                        finish();
                    } else {
                        dismissLoader();
                        tvInvalidMsg.setText(R.string.invalid_user_id_password);
                        tvInvalidMsg.setVisibility(View.VISIBLE);
                        Log.d("response failed", "failed");
                    }
                    // You can navigate to the next screen or perform other actions here
                } else {
                    // Handle the API error
                    // For example, show an error message to the user
                    dismissLoader();
                    tvInvalidMsg.setText(R.string.invalid_user_id_password);
                    tvInvalidMsg.setVisibility(View.VISIBLE);
                    Log.d("response failed", "failed");
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                // Handle network or other failures
                // For example, show a network error message
                dismissLoader();
                tvInvalidMsg.setText("Please check you Internet Connectivity");
                tvInvalidMsg.setVisibility(View.VISIBLE);
                Toast.makeText(LoginPage.this, "Please check you Internet Connectivity..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getDeviceIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();

                    // Check if it's not a loopback address and is IPv4
                    if (!inetAddress.isLoopbackAddress() && inetAddress.getAddress().length == 4) {
                        // Convert the byte array to a human-readable IP address
                        byte[] addressBytes = inetAddress.getAddress();
                        StringBuilder ipAddress = new StringBuilder();
                        for (int i = 0; i < addressBytes.length; i++) {
                            if (i > 0) {
                                ipAddress.append(".");
                            }
                            ipAddress.append(addressBytes[i] & 0xFF);
                        }
                        return ipAddress.toString();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private void showLoader() {
        progressDialog = new ProgressDialog(LoginPage.this);
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

}