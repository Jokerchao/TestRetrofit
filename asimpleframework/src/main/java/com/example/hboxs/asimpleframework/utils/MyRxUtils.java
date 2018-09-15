package com.example.hboxs.asimpleframework.utils;

import com.example.hboxs.asimpleframework.ApiException;
import com.example.hboxs.asimpleframework.HttpCode;
import com.example.hboxs.asimpleframework.model.http.HttpResult;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyRxUtils {

    public static <T>FlowableTransformer<T,T> toMain(Scheduler scheduler){
        return upstream -> upstream.subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> FlowableTransformer<HttpResult<T>,T> handReult(){
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(tHttpResult ->{
                    if (tHttpResult.getCode()==HttpCode.SUCCESS) {
                        return Flowable.just(tHttpResult.getData());
                    } else {
                        return Flowable.error(new ApiException(tHttpResult.getMsg(), tHttpResult.getCode()));
                    }
                });
    }

    private  static <T> Flowable<T> createData(final  T data){
        return Flowable.create(e -> {
            e.onNext(data);
            e.onComplete();
        },BackpressureStrategy.ERROR);
    }
}
