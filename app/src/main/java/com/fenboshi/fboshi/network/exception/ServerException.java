package com.fenboshi.fboshi.network.exception;

/**
 * 服务器返回的错误,如20001等
 */
public class ServerException extends RuntimeException {

    private int code;

    private String msg;

    public ServerException(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }
}