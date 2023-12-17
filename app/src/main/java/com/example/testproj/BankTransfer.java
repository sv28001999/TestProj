package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testproj.models.BankTransferReqBody;
import com.example.testproj.models.BankTransferResBody;
import com.example.testproj.models.Constants;
import com.example.testproj.models.IfscResponseBody;
import com.example.testproj.models.PaymentRes;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BankTransfer extends AppCompatActivity {

    private EditText txtAccountNo, txtConfirmAccountNo, txtImpsAmount, txtImpsDescription, txtBenificialName, txtIfscCode, txtEmail, txtMobile;
    private Button btnImpsPay;
    private ProgressDialog progressDialog;
    private ApiInterface apiInterface;
    private IfscApiInterface ifscInterface;
    String bankName, sfUserId;
    Boolean isValidIfsc = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_transfer);

        Toolbar toolbar = findViewById(R.id.bankTransToolbar);
        txtAccountNo = findViewById(R.id.txtAccountNo);
        txtConfirmAccountNo = findViewById(R.id.txtConfirmAccountNo);
        txtImpsAmount = findViewById(R.id.txtImpsAmount);
        txtImpsDescription = findViewById(R.id.txtImpsDescription);
        txtBenificialName = findViewById(R.id.txtBeneficierName);
        txtIfscCode = findViewById(R.id.txtIfscCode);
        btnImpsPay = findViewById(R.id.btnImpsPay);
        txtEmail = findViewById(R.id.txtBenEmail);
        txtMobile = findViewById(R.id.txtBenMobile);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Bank Transfer");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        Retrofit retrofit = RetrofitClient.getInstance();
        apiInterface = retrofit.create(ApiInterface.class);
        Retrofit ifscRetrofitClient = IfscRetrofitClient.getInstance();
        ifscInterface = ifscRetrofitClient.create(IfscApiInterface.class);

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        sfUserId = sharedPreferences.getString(Constants.SF_USER_ID, "NA");

        btnImpsPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String remark = txtImpsDescription.getText().toString();
                String amount = txtImpsAmount.getText().toString();
                String confirmAcc = txtConfirmAccountNo.getText().toString();
                String accountNo = txtAccountNo.getText().toString();
                String ifsc = txtIfscCode.getText().toString();
                String email = txtEmail.getText().toString();
                String mobile = txtMobile.getText().toString();
                String refId = generateUniqueId();
                String accountHolderName = txtBenificialName.getText().toString();
//                    Toast.makeText(BankTransfer.this, "Valid to pay", Toast.LENGTH_SHORT).show();
                if (remark.isEmpty()) {
                    remark = "null";
                }
                if (validated(accountNo, confirmAcc, amount, accountHolderName, ifsc, mobile, email)) {
                    startPayment(accountNo, amount, accountHolderName, ifsc, mobile, email, remark, refId);
                } else {
                    Log.d("isValidated", "false");
                }
            }
        });
    }

    public void startPayment(String accountNo, String amount, String name, String ifsc, String mobile, String email, String remark, String refId) {
        showLoader();
        Call<IfscResponseBody> call = ifscInterface.getIfscInfo(ifsc);

        call.enqueue(new Callback<IfscResponseBody>() {
            @Override
            public void onResponse(Call<IfscResponseBody> call, Response<IfscResponseBody> response) {
                if (response.isSuccessful()) {
                    IfscResponseBody ifscResponseBody = response.body();
                    bankName = ifscResponseBody.getBANK();
                    Log.d("isValidIfsc", "true");

                    Log.d("bankName", bankName);

                    BankTransferReqBody reqBody = new BankTransferReqBody("imps", remark, amount, accountNo, ifsc, "saving", name, mobile, email, refId, bankName, sfUserId);

                    Call<BankTransferResBody> bankCall = apiInterface.startBankTransfer(reqBody);
                    bankCall.enqueue(new Callback<BankTransferResBody>() {
                        @Override
                        public void onResponse(Call<BankTransferResBody> call, Response<BankTransferResBody> response) {
                            if (response.isSuccessful()) {
//                                startActivity(new Intent(BankTransfer.this, HomePage.class));
                                startActivity(new Intent(getApplicationContext(), PaymentSuccess.class));
                                finish();
                                Log.d("isValidTransaction", "true");
                                dismissLoader();
                            } else {
                                Toast.makeText(BankTransfer.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                                dismissLoader();
                            }
                        }

                        @Override
                        public void onFailure(Call<BankTransferResBody> call, Throwable t) {
                            Toast.makeText(BankTransfer.this, "Internet issue", Toast.LENGTH_SHORT).show();
                            dismissLoader();
                        }
                    });
                } else {
                    isValidIfsc = false;
                    txtIfscCode.setError("Invalid IFSC Code");
                    dismissLoader();
                    Log.d("isValidIfsc", "false");
                }
            }

            @Override
            public void onFailure(Call<IfscResponseBody> call, Throwable t) {
                isValidIfsc = false;
                dismissLoader();
                Toast.makeText(BankTransfer.this, "Network issue..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validated(String accountNo, String confirmAccNo, String amount, String name, String ifsc, String mobile, String email) {
        if (accountNo.isEmpty()) {
            txtAccountNo.setError("Please enter account number");
            return false;
        }
        if (accountNo.length() < 9 || accountNo.length() > 19) {
            txtAccountNo.setError("Invalid account number");
            return false;
        }

        if (confirmAccNo.isEmpty()) {
            txtConfirmAccountNo.setError("Please enter account number");
            return false;
        }
        if (!accountNo.equals(confirmAccNo)) {
            txtConfirmAccountNo.setError("Entered account number not matched");
//            Toast.makeText(this, "Not Matched", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (ifsc.isEmpty()) {
            txtIfscCode.setError("Please enter the IFSC code");
            return false;
        }
        if (ifsc.length() < 11) {
            txtIfscCode.setError("Invalid IFSC Code");
        }
        if (name.isEmpty()) {
            txtBenificialName.setError("Please enter the account holder name");
            return false;
        }
        if (mobile.isEmpty()) {
            txtMobile.setError("Please enter the mobile number");
            return false;
        }
        if (email.isEmpty()) {
            txtEmail.setError("Please enter the email");
            return false;
        }
        if (amount.isEmpty()) {
            txtImpsAmount.setError("Please enter the amount");
            return false;
        }
        if (!isNetworkAvailable()) {
            Toast.makeText(this, "Network Issue...", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public static String generateUniqueId() {
        // Get current timestamp in milliseconds
        long timestamp = System.currentTimeMillis();

        // Generate a random number
        int randomNum = (int) (Math.random() * 1000);

        return timestamp + "_" + randomNum;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }

    private void showLoader() {
        progressDialog = new ProgressDialog(BankTransfer.this);
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
}