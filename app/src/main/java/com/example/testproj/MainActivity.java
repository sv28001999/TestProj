package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        txtScannedText = findViewById(R.id.txtScannedText);
        //    Button startScannerBtn;
        Button startScanner = findViewById(R.id.startScannerButton);
//
//
//        scanButton = findViewById(R.id.scanButton);
//        resultTextView = findViewById(R.id.resultTextView);

        startScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScannerActivity.class));
            }
        });
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
                resultTextView.setText("Scanned Result: " + scannedResult);
            } else {
                resultTextView.setText("Scan canceled");
            }
        }
    }
}