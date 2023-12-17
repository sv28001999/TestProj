package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.Result;

//import me.dm7.barcodescanner.zxing.ZXingScannerView;

//public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
public class ScanCodeActivity extends AppCompatActivity {

//    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        scannerView = new ZXingScannerView(this);
////        setContentView(R.layout.activity_scan_code);
//        setContentView(scannerView);
    }

//    @Override
//    public void handleResult(Result result) {
//        MainActivity.txtScannedText.setText(result.getText());
//        onBackPressed();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        scannerView.stopCamera();
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        scannerView.setResultHandler(this);
//        scannerView.startCamera();
//    }
}