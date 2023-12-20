package com.example.testproj.models;

public class LoginRequestBody {
    public String userId;
    public String password;
    public String ipAddress;
    public String url;
    public int cookieLoginId;

    public LoginRequestBody() {
    }

    public LoginRequestBody(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public LoginRequestBody(String userId, String password, String ipAddress, String url, int cookieLoginId) {
        this.userId = userId;
        this.password = password;
        this.ipAddress = ipAddress;
        this.url = url;
        this.cookieLoginId = cookieLoginId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCookieLoginId() {
        return cookieLoginId;
    }

    public void setCookieLoginId(int cookieLoginId) {
        this.cookieLoginId = cookieLoginId;
    }
}
