package com.example.hboxs.asimpleframework.component;

import com.example.hboxs.asimpleframework.model.DataHelper;
import com.example.hboxs.asimpleframework.module.AppModule;
import com.example.hboxs.asimpleframework.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,HttpModule.class})
public interface AppComponent {
    DataHelper getDataHelper();
}
