package com.example.testproj.models;

public class UserDataRequestBody {
    String userId;

    public UserDataRequestBody() {
    }

    public UserDataRequestBody(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
