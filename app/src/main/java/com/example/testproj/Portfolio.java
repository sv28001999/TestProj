package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

public class Portfolio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        Toolbar toolbar = findViewById(R.id.myPortToolbar);

        // Set the custom Toolbar as the support action bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Portfolio");

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