package com.example.hboxs.asimpleframework;

import android.app.ActionBar;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hboxs.asimpleframework.base.BaseActivity;
import com.example.hboxs.asimpleframework.base.BaseMvpActivity;
import com.example.hboxs.asimpleframework.contract.MainContract;
import com.example.hboxs.asimpleframework.presenter.MainPresenter;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.IView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private View decorView;
    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_main;

    }

    @Override
    protected void initData() {
        super.initData();
        initToolbar(true,false,true).setMyTitle("主页").setMoreTitle("更多");
        basePresenter.loadData();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}
