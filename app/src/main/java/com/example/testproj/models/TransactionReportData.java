package com.example.testproj.models;

import java.util.ArrayList;

public class TransactionReportData {
    public String statusText;
    public int statusCode;
    public String statusType;
    public ArrayList<Data> data;

    public TransactionReportData() {
    }

    public TransactionReportData(String statusText, int statusCode, String statusType, ArrayList<Data> data) {
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

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public class Data {
        public int srno;
        public String UserId;
        public String Name;
        public String Provider;
        public double AmountInRupee;
        public double USDAmount;
        public String PaymentStatus;
        public String ReferenceNo;
        public String Bene_AccountNo;
        public String Bene_IFSC;
        public String Bene_AccountType;
        public String Bene_Email;
        public String Bene_Mobile;
        public String Bene_Name;
        public String Remarks;
        public String CreatedOn;

        public Data() {
        }

        public Data(int srno, String userId, String name, String provider, double amountInRupee, double USDAmount, String paymentStatus, String referenceNo, String bene_AccountNo, String bene_IFSC, String bene_AccountType, String bene_Email, String bene_Mobile, String bene_Name, String remarks, String createdOn) {
            this.srno = srno;
            UserId = userId;
            Name = name;
            Provider = provider;
            AmountInRupee = amountInRupee;
            this.USDAmount = USDAmount;
            PaymentStatus = paymentStatus;
            ReferenceNo = referenceNo;
            Bene_AccountNo = bene_AccountNo;
            Bene_IFSC = bene_IFSC;
            Bene_AccountType = bene_AccountType;
            Bene_Email = bene_Email;
            Bene_Mobile = bene_Mobile;
            Bene_Name = bene_Name;
            Remarks = remarks;
            CreatedOn = createdOn;
        }

        public int getSrno() {
            return srno;
        }

        public void setSrno(int srno) {
            this.srno = srno;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getProvider() {
            return Provider;
        }

        public void setProvider(String provider) {
            Provider = provider;
        }

        public double getAmountInRupee() {
            return AmountInRupee;
        }

        public void setAmountInRupee(double amountInRupee) {
            AmountInRupee = amountInRupee;
        }

        public double getUSDAmount() {
            return USDAmount;
        }

        public void setUSDAmount(double USDAmount) {
            this.USDAmount = USDAmount;
        }

        public String getPaymentStatus() {
            return PaymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            PaymentStatus = paymentStatus;
        }

        public String getReferenceNo() {
            return ReferenceNo;
        }

        public void setReferenceNo(String referenceNo) {
            ReferenceNo = referenceNo;
        }

        public String getBene_AccountNo() {
            return Bene_AccountNo;
        }

        public void setBene_AccountNo(String bene_AccountNo) {
            Bene_AccountNo = bene_AccountNo;
        }

        public String getBene_IFSC() {
            return Bene_IFSC;
        }

        public void setBene_IFSC(String bene_IFSC) {
            Bene_IFSC = bene_IFSC;
        }

        public String getBene_AccountType() {
            return Bene_AccountType;
        }

        public void setBene_AccountType(String bene_AccountType) {
            Bene_AccountType = bene_AccountType;
        }

        public String getBene_Email() {
            return Bene_Email;
        }

        public void setBene_Email(String bene_Email) {
            Bene_Email = bene_Email;
        }

        public String getBene_Mobile() {
            return Bene_Mobile;
        }

        public void setBene_Mobile(String bene_Mobile) {
            Bene_Mobile = bene_Mobile;
        }

        public String getBene_Name() {
            return Bene_Name;
        }

        public void setBene_Name(String bene_Name) {
            Bene_Name = bene_Name;
        }

        public String getRemarks() {
            return Remarks;
        }

        public void setRemarks(String remarks) {
            Remarks = remarks;
        }

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String createdOn) {
            CreatedOn = createdOn;
        }
    }
}
