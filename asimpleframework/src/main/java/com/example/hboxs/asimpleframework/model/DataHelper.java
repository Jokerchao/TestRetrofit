package com.example.hboxs.asimpleframework.model;

import com.example.hboxs.asimpleframework.model.http.HttpHelper;
import com.example.hboxs.asimpleframework.model.http.HttpNoResult;

import io.reactivex.Flowable;

public class DataHelper implements HttpHelper{
    private HttpHelper http;

    public DataHelper(HttpHelper http){
        this.http = http;
    }

    @Override
    public Flowable<HttpNoResult> loginCode(String phone) {
        return http.loginCode(phone);
    }
}
