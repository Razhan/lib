package com.example.library.presenter;


import com.example.library.base.MVPView;

/**
 * Created by ranzh on 1/5/2017.
 */

public abstract class BasePresenter<V extends MVPView> implements IPresenter {

    protected V view;

    @Override
    @SuppressWarnings("unchecked")
    public void attachView(MVPView view) {
        this.view = (V)view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public V getView() {
        return view;
    }
}
