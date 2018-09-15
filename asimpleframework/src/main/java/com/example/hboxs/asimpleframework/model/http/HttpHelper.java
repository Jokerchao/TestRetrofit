package com.example.hboxs.asimpleframework.model.http;

import io.reactivex.Flowable;

public interface HttpHelper {
    /**
     *
     * @param phone 手机号
     * @return {"code":0}
     */
    Flowable<HttpNoResult> loginCode(String phone);
}
