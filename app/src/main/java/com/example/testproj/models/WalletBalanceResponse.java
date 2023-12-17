package com.example.testproj.models;

public class WalletBalanceResponse {
    public String status;
    public String balance;
    public int response_code;
    public String message;

    public WalletBalanceResponse() {
    }

    public WalletBalanceResponse(String status, String balance, int response_code, String message) {
        this.status = status;
        this.balance = balance;
        this.response_code = response_code;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
