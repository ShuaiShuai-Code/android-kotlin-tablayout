package com.fenboshi.fboshi.network.model;


public class NoDataResponse {

    private int retCode;

    private String errorMsg;

    public int getCode() {
        return retCode;
    }

    public void setCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return errorMsg;
    }

    public void setMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
