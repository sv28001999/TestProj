package com.example.testproj.models;

public class LoginResponse {
    public boolean status;
    public String message;
    public Data data;

    public LoginResponse() {
    }

    public LoginResponse(boolean status, String message, Data data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
