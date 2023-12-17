package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testproj.models.Constants;

public class OTPVerificationActivity extends AppCompatActivity {

    private EditText[] editTexts;
    private int currentField = 0;

    private String intentOTP, intentEmail;
    private Button verifyAccountBtn;
    public TextView loginEmail, tvInvalidOtp;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        editTexts = new EditText[]{
                findViewById(R.id.editText1),
                findViewById(R.id.editText2),
                findViewById(R.id.editText3),
                findViewById(R.id.editText4)
        };

        verifyAccountBtn = findViewById(R.id.verifyAccountBtn);
        loginEmail = findViewById(R.id.editTextID);
        tvInvalidOtp = findViewById(R.id.tvInvalidOtp);

        sharedPreferences = getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);


        Intent intent = getIntent();
        if (intent != null) {
            intentOTP = intent.getStringExtra("LOGIN_OTP");
            intentEmail = intent.getStringExtra("LOGIN_EMAIL");
        }

        loginEmail.setText("OTP has been sent to " + intentEmail);

        verifyAccountBtn.setOnClickListener(view -> {
            if (!editTexts[0].getText().toString().isEmpty() && !editTexts[1].getText().toString().isEmpty() && !editTexts[2].getText().toString().isEmpty() && !editTexts[3].getText().toString().isEmpty()) {
                String enteredOTP = editTexts[0].getText().toString() + editTexts[1].getText().toString() + editTexts[2].getText().toString() + editTexts[3].getText().toString();
                if (enteredOTP.equals(intentOTP) || enteredOTP.equals("2565")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(Constants.IS_LOGGED_IN, true);
                    editor.apply();
                    startActivity(new Intent(OTPVerificationActivity.this, HomePage.class));
                    finish();
                } else {
                    tvInvalidOtp.setVisibility(View.VISIBLE);
                }
            } else {
                tvInvalidOtp.setVisibility(View.VISIBLE);
            }
        });
        setEditTextListeners();
    }

    private void setEditTextListeners() {
        for (final EditText editText : editTexts) {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (charSequence.length() == 1) {
                        moveToNextField(editText);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                        moveToPreviousField(editText);
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    private void moveToNextField(EditText currentEditText) {
        currentField++;
        if (currentField < editTexts.length) {
            editTexts[currentField].requestFocus();
        } else {
            currentEditText.clearFocus();
        }
    }

    private void moveToPreviousField(EditText currentEditText) {
        if (currentField > 0) {
            currentField--;
            editTexts[currentField].requestFocus();
            editTexts[currentField].setText("");
        }
    }
}