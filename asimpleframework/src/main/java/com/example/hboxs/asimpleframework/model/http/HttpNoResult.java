package com.example.hboxs.asimpleframework.model.http;

public class HttpNoResult {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public HttpNoResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public HttpNoResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "HttpNoResult{" + "code=" + code + "msg" + msg + '\'' +'}';
    }
}
