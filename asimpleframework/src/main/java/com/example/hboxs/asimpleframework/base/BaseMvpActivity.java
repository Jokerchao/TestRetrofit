package com.example.hboxs.asimpleframework.base;

import javax.inject.Inject;

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity{
    @Inject
    protected T basePresenter;

    @Override
    @SuppressWarnings("unchecked")
    protected void initView() {
        super.initView();
        initInject();
        if(null != basePresenter){
            basePresenter.attachView(this);
        }
    }

    protected abstract void initInject();

    @Override
    protected void onDestroy() {
        if (null != basePresenter) {
            basePresenter.detachView();
            basePresenter = null;
        }
            super.onDestroy();
    }
}
