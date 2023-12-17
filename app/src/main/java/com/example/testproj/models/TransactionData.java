package com.example.testproj.models;

import java.util.ArrayList;

public class TransactionData {

    public int statuscode;
    public int responsecode;
    public boolean status;
    public String message;
    public ArrayList<Datum> data;

    public TransactionData() {
    }

    public TransactionData(int statuscode, int responsecode, boolean status, String message, ArrayList<Datum> data) {
        this.statuscode = statuscode;
        this.responsecode = responsecode;
        this.status = status;
        this.message = message;
        this.data = data;
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

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }


    public class Datum {
        public String srno;
        public String memberid;
        public String refId;
        public String amount;
        public String vpa_id;
        public String amountInUSD;
        public String message;
        public String remarks;
        public String bankname;
        public String bankaccount;
        public String accounT_TYPE;
        public String aC_NAME;
        public String ifsc;
        public String mobileno;
        public String mode;
        public String transactioN_DATE;

        public Datum() {
        }

        public Datum(String srno, String memberid, String refId, String amount, String vpa_id, String amountInUSD, String message, String remarks, String bankname, String bankaccount, String accounT_TYPE, String aC_NAME, String ifsc, String mobileno, String mode, String transactioN_DATE) {
            this.srno = srno;
            this.memberid = memberid;
            this.refId = refId;
            this.amount = amount;
            this.vpa_id = vpa_id;
            this.amountInUSD = amountInUSD;
            this.message = message;
            this.remarks = remarks;
            this.bankname = bankname;
            this.bankaccount = bankaccount;
            this.accounT_TYPE = accounT_TYPE;
            this.aC_NAME = aC_NAME;
            this.ifsc = ifsc;
            this.mobileno = mobileno;
            this.mode = mode;
            this.transactioN_DATE = transactioN_DATE;
        }

        public String getSrno() {
            return srno;
        }

        public void setSrno(String srno) {
            this.srno = srno;
        }

        public String getMemberid() {
            return memberid;
        }

        public void setMemberid(String memberid) {
            this.memberid = memberid;
        }

        public String getRefId() {
            return refId;
        }

        public void setRefId(String refId) {
            this.refId = refId;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getVpa_id() {
            return vpa_id;
        }

        public void setVpa_id(String vpa_id) {
            this.vpa_id = vpa_id;
        }

        public String getAmountInUSD() {
            return amountInUSD;
        }

        public void setAmountInUSD(String amountInUSD) {
            this.amountInUSD = amountInUSD;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getBankname() {
            return bankname;
        }

        public void setBankname(String bankname) {
            this.bankname = bankname;
        }

        public String getBankaccount() {
            return bankaccount;
        }

        public void setBankaccount(String bankaccount) {
            this.bankaccount = bankaccount;
        }

        public String getAccounT_TYPE() {
            return accounT_TYPE;
        }

        public void setAccounT_TYPE(String accounT_TYPE) {
            this.accounT_TYPE = accounT_TYPE;
        }

        public String getaC_NAME() {
            return aC_NAME;
        }

        public void setaC_NAME(String aC_NAME) {
            this.aC_NAME = aC_NAME;
        }

        public String getIfsc() {
            return ifsc;
        }

        public void setIfsc(String ifsc) {
            this.ifsc = ifsc;
        }

        public String getMobileno() {
            return mobileno;
        }

        public void setMobileno(String mobileno) {
            this.mobileno = mobileno;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getTransactioN_DATE() {
            return transactioN_DATE;
        }

        public void setTransactioN_DATE(String transactioN_DATE) {
            this.transactioN_DATE = transactioN_DATE;
        }
    }
}
