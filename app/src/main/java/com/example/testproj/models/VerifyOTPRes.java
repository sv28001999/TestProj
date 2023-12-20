package com.example.testproj.models;

public class VerifyOTPRes {
    public String statusText;
    public int statusCode;
    public String statusType;
    public Data data;

    public VerifyOTPRes() {
    }

    public VerifyOTPRes(String statusText, int statusCode, String statusType, Data data) {
        this.statusText = statusText;
        this.statusCode = statusCode;
        this.statusType = statusType;
        this.data = data;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        public String name;
        public String userId;
        public String emailId;
        public String mobileNo;
        public String type;
        public String token;

        public Data() {
        }

        public Data(String name, String userId, String emailId, String mobileNo, String type, String token) {
            this.name = name;
            this.userId = userId;
            this.emailId = emailId;
            this.mobileNo = mobileNo;
            this.type = type;
            this.token = token;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}