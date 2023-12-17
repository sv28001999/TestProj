package com.example.testproj.models;

public class PaymentReq {
    public String refid;
    public String vpa_id;
    public String amount;
    public String remarks;
    public String userId;

    public PaymentReq() {
    }

    public PaymentReq(String refid, String vpa_id, String amount, String remarks, String userId) {
        this.refid = refid;
        this.vpa_id = vpa_id;
        this.amount = amount;
        this.remarks = remarks;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public String getVpa_id() {
        return vpa_id;
    }

    public void setVpa_id(String vpa_id) {
        this.vpa_id = vpa_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
