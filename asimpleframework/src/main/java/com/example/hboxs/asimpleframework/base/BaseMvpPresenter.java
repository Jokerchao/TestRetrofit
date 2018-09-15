package com.example.hboxs.asimpleframework.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseMvpPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T baseView;
    private CompositeDisposable disposables;
    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void detachView() {
        this.baseView = null;
        unSubscribe();
    }

    private void unSubscribe() {
        if (null != disposables) {
            disposables.clear();
            disposables = null;
        }
    }


}
