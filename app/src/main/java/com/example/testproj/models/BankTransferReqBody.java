package com.example.testproj.models;

public class BankTransferReqBody {
    public String mode;
    public String remarks;
    public String amount;
    public String bene_acc;
    public String bene_ifsc;
    public String bene_acc_type;
    public String bene_name;
    public String bene_mobile;
    public String bene_email;
    public String refid;
    public String bene_bank_name;
    public String userId;

    public BankTransferReqBody() {
    }

    public BankTransferReqBody(String mode, String remarks, String amount, String bene_acc, String bene_ifsc, String bene_acc_type, String bene_name, String bene_mobile, String bene_email, String refid, String bene_bank_name, String userId) {
        this.mode = mode;
        this.remarks = remarks;
        this.amount = amount;
        this.bene_acc = bene_acc;
        this.bene_ifsc = bene_ifsc;
        this.bene_acc_type = bene_acc_type;
        this.bene_name = bene_name;
        this.bene_mobile = bene_mobile;
        this.bene_email = bene_email;
        this.refid = refid;
        this.bene_bank_name = bene_bank_name;
        this.userId = userId;
    }

    public String getBene_name() {
        return bene_name;
    }

    public void setBene_name(String bene_name) {
        this.bene_name = bene_name;
    }

    public String getBene_mobile() {
        return bene_mobile;
    }

    public void setBene_mobile(String bene_mobile) {
        this.bene_mobile = bene_mobile;
    }

    public String getBene_email() {
        return bene_email;
    }

    public void setBene_email(String bene_email) {
        this.bene_email = bene_email;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBene_acc() {
        return bene_acc;
    }

    public void setBene_acc(String bene_acc) {
        this.bene_acc = bene_acc;
    }

    public String getBene_ifsc() {
        return bene_ifsc;
    }

    public void setBene_ifsc(String bene_ifsc) {
        this.bene_ifsc = bene_ifsc;
    }

    public String getBene_acc_type() {
        return bene_acc_type;
    }

    public void setBene_acc_type(String bene_acc_type) {
        this.bene_acc_type = bene_acc_type;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public String getBene_bank_name() {
        return bene_bank_name;
    }

    public void setBene_bank_name(String bene_bank_name) {
        this.bene_bank_name = bene_bank_name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
