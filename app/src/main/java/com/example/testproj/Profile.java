package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testproj.models.Constants;

public class Profile extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView tvFullname, tvMobileNo, tvEmail, tvUserId, tvJoiningDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvFullname = findViewById(R.id.tvpFullName);
        tvMobileNo = findViewById(R.id.tvpMobileNo);
        tvEmail = findViewById(R.id.tvpEmailId);
        tvJoiningDate = findViewById(R.id.tvpJoiningDate);
        tvUserId = findViewById(R.id.tvpUserId);

        sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);

        String userId = sharedPreferences.getString(Constants.SF_USER_ID, "NA");
        String fullName = sharedPreferences.getString(Constants.SF_FULL_NAME, "NA");
        String emailId = sharedPreferences.getString(Constants.SF_EMAIL, "NA");
        String mobileNo = sharedPreferences.getString(Constants.SF_MOBILE, "NA");
        String joiningDate = sharedPreferences.getString(Constants.SF_JOINING_DATE, "NA");

        tvFullname.setText(fullName);
        tvUserId.setText(userId);
        tvEmail.setText(emailId);
        tvMobileNo.setText(mobileNo);
        tvJoiningDate.setText(joiningDate);

        Toolbar toolbar = findViewById(R.id.myProfToolbar);

        // Set the custom Toolbar as the support action bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My Profile");

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