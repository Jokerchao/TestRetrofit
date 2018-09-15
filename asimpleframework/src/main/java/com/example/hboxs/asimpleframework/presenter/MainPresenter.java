package com.example.hboxs.asimpleframework.presenter;

import com.example.hboxs.asimpleframework.MyApplication;
import com.example.hboxs.asimpleframework.MySubscriber;
import com.example.hboxs.asimpleframework.base.BaseMvpPresenter;
import com.example.hboxs.asimpleframework.contract.MainContract;
import com.example.hboxs.asimpleframework.model.DataHelper;
import com.example.hboxs.asimpleframework.model.http.HttpResult;
import com.example.hboxs.asimpleframework.utils.MyRxUtils;

import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

public class MainPresenter extends BaseMvpPresenter<MainContract.IView>
    implements  MainContract.Presenter{
    private DataHelper dataHelper;
    @Inject
    MainPresenter(){
        dataHelper = MyApplication.getAppComponent().getDataHelper();
    }

    @Override
    public void loadData() {
        //baseView.showTipMsg("加载数据");
        //未找到如何处理该处
//        addSubscribe(dataHelper.loginCode("134xxxxxxxx")
//                .compose(MyRxUtils.toMain(Schedulers.io()))
//                .subscribeWith(new MySubscriber<HttpResult>(baseView,true){
//                    @Override
//                    public void onNext(HttpResult httpResult) {
//                    }
//                }));
    }
}
