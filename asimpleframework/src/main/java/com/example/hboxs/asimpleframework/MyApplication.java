package com.example.hboxs.asimpleframework;

import android.app.Application;

import com.example.hboxs.asimpleframework.component.AppComponent;
import com.example.hboxs.asimpleframework.component.DaggerAppComponent;
import com.example.hboxs.asimpleframework.module.AppModule;
import com.example.hboxs.asimpleframework.module.HttpModule;
import com.squareup.leakcanary.LeakCanary;

public class MyApplication extends Application {
    private static MyApplication instance;
    private static AppComponent appComponent;

    public static MyApplication getInstance(){
        return instance;
    }

    private void setInstance(MyApplication instance){
        MyApplication.instance = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);
        initLeakCanary();
    }

    /**
     * 初始化内存检测工具
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    /**
     *
     * @return AppCompoent
     */
    public static synchronized AppComponent getAppComponent(){
        if (null == appComponent) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(getInstance()))
                    .httpModule(new HttpModule())
                    .build();
        }
            return appComponent;
    }


}
