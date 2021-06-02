package com.fenboshi.fboshi.network.rx;

public class BaseResponse<T> {

    private T data;
    private int code;
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getRetCode() {
        return code;
    }

    public void setRetCode(int retCode) {
        this.code = retCode;
    }

    public String getErrorMsg() {
        return msg;
    }

    public void setErrorMsg(String errorMsg) {
        this.msg = errorMsg;
    }

}
