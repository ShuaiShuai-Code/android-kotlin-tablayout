package com.fenboshi.fboshi.network.exception;


public  class ResponeThrowable extends Exception {
    private int code;
    private String message;

    public ResponeThrowable(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "ResponeThrowable{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}