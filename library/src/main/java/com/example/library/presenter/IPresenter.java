package com.example.library.presenter;

import android.content.Context;

import com.example.library.base.ui.MVPView;

public interface IPresenter {

    void attachView(MVPView view);

    void detachView();

    boolean isViewAttached();

    MVPView getView();

    Context getContext();

    void unSubscribe();

}
