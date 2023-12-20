package com.example.testproj.models;

public class VerifyOTPReq {
    public String userId;
    public int otp;

    public VerifyOTPReq() {
    }

    public VerifyOTPReq(String userId, int otp) {
        this.userId = userId;
        this.otp = otp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
