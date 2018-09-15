package com.example.hboxs.asimpleframework.component;

import com.example.hboxs.asimpleframework.MainActivity;
import com.example.hboxs.asimpleframework.module.ActivityModule;
import com.example.hboxs.asimpleframework.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent  {
    void inject(MainActivity mainActivity);
}
