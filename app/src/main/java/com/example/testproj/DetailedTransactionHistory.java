package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testproj.models.Constants;
import com.example.testproj.models.TransactionData;

import java.text.DecimalFormat;
import java.util.Objects;

public class DetailedTransactionHistory extends AppCompatActivity {

    private TextView txtAmount, txtSendBy, txtDate, txtVpaId, txtRefId, txtMode, txtRemark, txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_transaction_history);

        txtAmount = findViewById(R.id.txtTrxnDetailAmount);
        txtSendBy = findViewById(R.id.txtTrxnDetailSendBy);
        txtDate = findViewById(R.id.txtTrxnDetailDate);
        txtVpaId = findViewById(R.id.txtTrxnDetailVpaId);
        txtRemark = findViewById(R.id.txtTrxnDetailRemark);
        txtMode = findViewById(R.id.txtTrxnDetailMode);
        txtStatus = findViewById(R.id.txtTrxnDetailStatus);
        txtRefId = findViewById(R.id.txtTrxnDetailId);

        DecimalFormat df = new DecimalFormat("#.##");

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);

        txtAmount.setText("₹" + df.format(Double.parseDouble(Objects.requireNonNull(getIntent().getStringExtra(TransactionConstants.AMOUNT)))));
//        txtUsdtAmount.setText(getIntent().getStringExtra(TransactionConstants.USDT_AMOUNT));
        txtSendBy.setText(sharedPreferences.getString(Constants.SF_USER_ID, "NA"));
        txtDate.setText(getIntent().getStringExtra(TransactionConstants.DATE));
        txtVpaId.setText(getIntent().getStringExtra(TransactionConstants.VPA_ID));
        txtRemark.setText(getIntent().getStringExtra(TransactionConstants.REMARK));
        txtMode.setText(getIntent().getStringExtra(TransactionConstants.MODE));
        txtStatus.setText(getIntent().getStringExtra(TransactionConstants.STATUS));
        txtRefId.setText(getIntent().getStringExtra(TransactionConstants.REF_ID));

        Toolbar toolbar = findViewById(R.id.myTrxnDetailToolbar);

        // Set the custom Toolbar as the support action bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        // Enable the "Up" button (back button) functionality
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Handle the "Up" button click to navigate to the previous page
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); // or implement your own navigation logic
            }
        });

    }
}