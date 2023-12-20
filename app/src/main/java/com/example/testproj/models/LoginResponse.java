package com.example.testproj.models;

public class LoginResponse {
    public int statusCode;
    public String statusText;
    public String statusType;
    public Data data;

    public LoginResponse() {
    }

    public LoginResponse(int statusCode, String statusText, String statusType) {
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.statusType = statusType;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    //    public LoginResponse(int statusCode, String statusText, Data data) {
//        this.statusCode = statusCode;
//        this.statusText = statusText;
//        this.data = data;
//    }

    public int isstatusCode() {
        return statusCode;
    }

    public void setstatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getstatusText() {
        return statusText;
    }

    public void setstatusText(String statusText) {
        this.statusText = statusText;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        public String valid;
        public String memberId;
        public String userId;
        public String password;
        public String type;
        public String name;
        public String mobileNo;
        public String emailId;
        public String isLoginOTPRequired;
        public String loginId;
        public String otp;

        public Data(String valid, String memberId, String userId, String password, String type, String name, String mobileNo, String emailId, String isLoginOTPRequired, String loginId) {
            this.valid = valid;
            this.memberId = memberId;
            this.userId = userId;
            this.password = password;
            this.type = type;
            this.name = name;
            this.mobileNo = mobileNo;
            this.emailId = emailId;
            this.isLoginOTPRequired = isLoginOTPRequired;
            this.loginId = loginId;
        }

        public Data(String valid, String memberId, String userId, String password, String type, String name, String mobileNo, String emailId, String isLoginOTPRequired, String loginId, String otp) {
            this.valid = valid;
            this.memberId = memberId;
            this.userId = userId;
            this.password = password;
            this.type = type;
            this.name = name;
            this.mobileNo = mobileNo;
            this.emailId = emailId;
            this.isLoginOTPRequired = isLoginOTPRequired;
            this.loginId = loginId;
            this.otp = otp;
        }

        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }

        public String getValid() {
            return valid;
        }

        public void setValid(String valid) {
            this.valid = valid;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getIsLoginOTPRequired() {
            return isLoginOTPRequired;
        }

        public void setIsLoginOTPRequired(String isLoginOTPRequired) {
            this.isLoginOTPRequired = isLoginOTPRequired;
        }

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }
    }
}
