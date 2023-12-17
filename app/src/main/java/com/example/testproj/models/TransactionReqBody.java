package com.example.testproj.models;

public class TransactionReqBody {

    public String userId;
    public String txnFromDate;
    public String txnToDate;
    public String upiId;
    public int pageNo;
    public int pageSize;

    public TransactionReqBody() {
    }

    public TransactionReqBody(String userId, String txnFromDate, String txnToDate) {
        this.userId = userId;
        this.txnFromDate = txnFromDate;
        this.txnToDate = txnToDate;
    }

    public TransactionReqBody(String userId, String txnFromDate, String txnToDate, String upiId, int pageNo, int pageSize) {
        this.userId = userId;
        this.txnFromDate = txnFromDate;
        this.txnToDate = txnToDate;
        this.upiId = upiId;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTxnFromDate() {
        return txnFromDate;
    }

    public void setTxnFromDate(String txnFromDate) {
        this.txnFromDate = txnFromDate;
    }

    public String getTxnToDate() {
        return txnToDate;
    }

    public void setTxnToDate(String txnToDate) {
        this.txnToDate = txnToDate;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
