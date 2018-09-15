package com.example.hboxs.asimpleframework.module;

import com.example.hboxs.asimpleframework.model.http.ProtocolHttp;
import com.example.hboxs.asimpleframework.model.http.api.HttpApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public  class HttpModule {
    @Provides
    @Singleton
    OkHttpClient.Builder providesOkHttpHelper(){
        return  new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS);
    }

    @Provides
    @Singleton
    OkHttpClient provideClient(OkHttpClient.Builder builder){
        return builder
                .build();
    }

    @Provides
    @Singleton
    Retrofit.Builder providesRetrofitBuilder(){
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    HttpApi provideApi(@ApiUrl Retrofit retrofit){
        return retrofit.create(HttpApi.class);
    }

    @Provides
    @Singleton
    @ApiUrl
    Retrofit providesApiRetrofit(Retrofit.Builder builder, OkHttpClient client){
        return createRetrofit(builder,client, ProtocolHttp.HTTP_HOST);
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String httpHost) {
        return builder.client(client)
                .baseUrl(httpHost)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
