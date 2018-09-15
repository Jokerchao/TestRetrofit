package com.example.hboxs.asimpleframework.model.http.api;

import com.example.hboxs.asimpleframework.model.http.HttpNoResult;
import com.example.hboxs.asimpleframework.model.http.ProtocolHttp;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HttpApi {

    @FormUrlEncoded
    @POST(ProtocolHttp.METHOD_LOGIN_CODE)
    Flowable<HttpNoResult> loginCode(@Field("phone") String phone);
}
