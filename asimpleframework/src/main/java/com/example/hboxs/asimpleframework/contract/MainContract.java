package com.example.hboxs.asimpleframework.contract;

import com.example.hboxs.asimpleframework.base.BasePresenter;
import com.example.hboxs.asimpleframework.base.BaseView;

public interface MainContract {
    interface  IView extends BaseView{

    }
    interface  Presenter extends BasePresenter<IView>{
        void loadData();
    }
}
