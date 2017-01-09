package com.example.library.presenter;

import android.content.Context;

import com.example.library.base.MVPView;

/**
 * Created by ranzh on 1/6/2017.
 */

public interface IPresenter {

    void attachView(MVPView view);

    void detachView();

    boolean isViewAttached();

    MVPView getView();

    Context getContext();

}
