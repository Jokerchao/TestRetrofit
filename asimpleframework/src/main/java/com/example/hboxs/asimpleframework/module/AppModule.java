package com.example.hboxs.asimpleframework.module;

import com.example.hboxs.asimpleframework.MyApplication;
import com.example.hboxs.asimpleframework.model.DataHelper;
import com.example.hboxs.asimpleframework.model.http.HttpHelper;
import com.example.hboxs.asimpleframework.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppModule {
    private MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    DataHelper provideDataHelper(HttpHelper httpHelper){
        return new DataHelper(httpHelper);
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper){
        return retrofitHelper;
    }
}
