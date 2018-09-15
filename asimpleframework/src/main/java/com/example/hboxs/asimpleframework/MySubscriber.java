package com.example.hboxs.asimpleframework;

import com.example.hboxs.asimpleframework.base.BaseView;

import io.reactivex.subscribers.ResourceSubscriber;

public class MySubscriber<T> extends ResourceSubscriber<T> {
    private BaseView baseView;
    private boolean showloading;

    public MySubscriber(BaseView baseView) {
        this.baseView = baseView;
    }

    public MySubscriber(BaseView baseView, boolean showloading) {
        this.baseView = baseView;
        this.showloading = showloading;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (null != baseView && showloading) {
            baseView.showLoading();
        }
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {
        if(null == baseView){
            return;
        }
        baseView.hideLoading();
        if(t instanceof  ApiException){
            ApiException apiException = (ApiException) t;
            switch (apiException.getCode()){
                case HttpCode.NO_PARAMETER:
                    baseView.showTipMsg("参数为空");
                    break;
                case HttpCode.SERVER_ERR:
                    baseView.showTipMsg("服务器错误");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onComplete() {
        if (null != baseView) {
            baseView.hideLoading();
        }
    }
}
