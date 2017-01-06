package com.example.ranzh.lib.test;

import android.util.Log;

import com.example.library.presenter.BasePresenter;

/**
 * Created by ranzh on 1/6/2017.
 */

public final class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {

    @Override
    public void testPres() {
        Log.d("testPres", "testPres");
        getView().testView();
    }

}
