package com.example.hboxs.asimpleframework.base;

public interface BasePresenter <T extends BaseView> {
    void attachView(T baseView);

    void detachView();
}
