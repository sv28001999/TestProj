package com.example.testproj.models;

public class PaymentRes {
    public int statuscode;
    public int responsecode;
    public int orderid;
    public String utr;
    public boolean status;
    public String message;

    public PaymentRes() {
    }

    public PaymentRes(int statuscode, int responsecode, int orderid, boolean status, String message) {
        this.statuscode = statuscode;
        this.responsecode = responsecode;
        this.orderid = orderid;
        this.status = status;
        this.message = message;
    }

    public PaymentRes(int statuscode, int responsecode, int orderid, String utr, boolean status, String message) {
        this.statuscode = statuscode;
        this.responsecode = responsecode;
        this.orderid = orderid;
        this.utr = utr;
        this.status = status;
        this.message = message;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getUtr() {
        return utr;
    }

    public void setUtr(String utr) {
        this.utr = utr;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public int getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(int responsecode) {
        this.responsecode = responsecode;
    }

    public boolean getStatus() {
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
}
