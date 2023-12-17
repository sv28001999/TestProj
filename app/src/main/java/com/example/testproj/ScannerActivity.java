package com.example.testproj;

import android.Manifest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.example.testproj.models.Constants;

import androidx.core.content.ContextCompat;

public class ScannerActivity extends AppCompatActivity {
    private CodeScanner mCodeScanner;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        CodeScannerView scannerView = findViewById(R.id.scannerView);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setAutoFocusEnabled(true);
        mCodeScanner.setAutoFocusInterval(1000);
        mCodeScanner.setTouchFocusEnabled(true);
        mCodeScanner.setFlashEnabled(true);
        mCodeScanner.setDecodeCallback(result -> runOnUiThread(() -> {
            // Handle the decoded QR code result here
            Constants.SCANNED_TEXT = result.getText();
            Log.d("Scanned Text", result.getText());
            Constants.IS_SCANNED = true;
            startActivity(new Intent(getApplicationContext(), PaymentPage.class));
            finish();
        }));
        mCodeScanner.setErrorCallback(error -> {
            // Handle error
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            startScanning();
        }
    }

    private void startScanning() {
        mCodeScanner.startPreview();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startScanning();
            } else {
                Toast.makeText(this, "Camera permission required", Toast.LENGTH_SHORT).show();
            }
        }
    }
}