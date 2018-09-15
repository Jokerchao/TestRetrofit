package com.example.hboxs.asimpleframework.model.http;

import com.example.hboxs.asimpleframework.model.http.api.HttpApi;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class RetrofitHelper implements HttpHelper{
    private HttpApi httpApi;

    @Inject
    RetrofitHelper(HttpApi httpApi) {
        this.httpApi = httpApi;
    }


    @Override
    public Flowable<HttpNoResult> loginCode(String phone) {
        return httpApi.loginCode(phone);
    }
}
