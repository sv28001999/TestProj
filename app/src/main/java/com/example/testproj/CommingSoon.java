package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class CommingSoon extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comming_soon);

        Toolbar toolbar = findViewById(R.id.cs_toolbar);

        // Set the custom Toolbar as the support action bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Back");

        // Enable the "Up" button (back button) functionality
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Handle the "Up" button click to navigate to the previous page
        toolbar.setNavigationOnClickListener(view -> {
            onBackPressed(); // or implement your own navigation logic
        });
    }
}