package com.example.testproj.models;

public class IfscResponseBody {
    public String MICR;
    public String BRANCH;
    public String ADDRESS;
    public String STATE;
    public String CONTACT;
    public boolean UPI;
    public boolean RTGS;
    public String CITY;
    public String CENTRE;
    public String DISTRICT;
    public boolean NEFT;
    public boolean IMPS;
    public String SWIFT;
    public String ISO3166;
    public String BANK;
    public String BANKCODE;
    public String IFSC;

    public IfscResponseBody() {
    }

    public IfscResponseBody(String MICR, String BRANCH, String ADDRESS, String STATE, String CONTACT, boolean UPI, boolean RTGS, String CITY, String CENTRE, String DISTRICT, boolean NEFT, boolean IMPS, String SWIFT, String ISO3166, String BANK, String BANKCODE, String IFSC) {
        this.MICR = MICR;
        this.BRANCH = BRANCH;
        this.ADDRESS = ADDRESS;
        this.STATE = STATE;
        this.CONTACT = CONTACT;
        this.UPI = UPI;
        this.RTGS = RTGS;
        this.CITY = CITY;
        this.CENTRE = CENTRE;
        this.DISTRICT = DISTRICT;
        this.NEFT = NEFT;
        this.IMPS = IMPS;
        this.SWIFT = SWIFT;
        this.ISO3166 = ISO3166;
        this.BANK = BANK;
        this.BANKCODE = BANKCODE;
        this.IFSC = IFSC;
    }

    public String getMICR() {
        return MICR;
    }

    public void setMICR(String MICR) {
        this.MICR = MICR;
    }

    public String getBRANCH() {
        return BRANCH;
    }

    public void setBRANCH(String BRANCH) {
        this.BRANCH = BRANCH;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getCONTACT() {
        return CONTACT;
    }

    public void setCONTACT(String CONTACT) {
        this.CONTACT = CONTACT;
    }

    public boolean isUPI() {
        return UPI;
    }

    public void setUPI(boolean UPI) {
        this.UPI = UPI;
    }

    public boolean isRTGS() {
        return RTGS;
    }

    public void setRTGS(boolean RTGS) {
        this.RTGS = RTGS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getCENTRE() {
        return CENTRE;
    }

    public void setCENTRE(String CENTRE) {
        this.CENTRE = CENTRE;
    }

    public String getDISTRICT() {
        return DISTRICT;
    }

    public void setDISTRICT(String DISTRICT) {
        this.DISTRICT = DISTRICT;
    }

    public boolean isNEFT() {
        return NEFT;
    }

    public void setNEFT(boolean NEFT) {
        this.NEFT = NEFT;
    }

    public boolean isIMPS() {
        return IMPS;
    }

    public void setIMPS(boolean IMPS) {
        this.IMPS = IMPS;
    }

    public String getSWIFT() {
        return SWIFT;
    }

    public void setSWIFT(String SWIFT) {
        this.SWIFT = SWIFT;
    }

    public String getISO3166() {
        return ISO3166;
    }

    public void setISO3166(String ISO3166) {
        this.ISO3166 = ISO3166;
    }

    public String getBANK() {
        return BANK;
    }

    public void setBANK(String BANK) {
        this.BANK = BANK;
    }

    public String getBANKCODE() {
        return BANKCODE;
    }

    public void setBANKCODE(String BANKCODE) {
        this.BANKCODE = BANKCODE;
    }

    public String getIFSC() {
        return IFSC;
    }

    public void setIFSC(String IFSC) {
        this.IFSC = IFSC;
    }
}
