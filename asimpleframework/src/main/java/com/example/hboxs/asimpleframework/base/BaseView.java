package com.example.hboxs.asimpleframework.base;

import android.support.annotation.StringRes;

public interface BaseView {
    void showTipMsg(String msg);

    void showTipMsg(@StringRes int msg);

    void showLoading();

    void hideLoading();

    void invalidToken();

    void myFinish();
}


