package com.example.library.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.library.presenter.BasePresenter;


/**
 * Created by ranzh on 1/5/2017.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements MVPView {

    private P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = createPresenter();
        presenter.attachView(this);
    }

    @NonNull
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }

        super.onDestroy();
    }

    @NonNull
    public P presenter() {
        return presenter;
    }

    @Override
    public void showMessage(String msg) {
        showToast(msg);
    }

    @Override
    public Context context() {
        return this;
    }
}
