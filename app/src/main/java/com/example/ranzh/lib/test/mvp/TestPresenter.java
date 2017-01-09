package com.example.ranzh.lib.test.mvp;

import android.app.Activity;
import android.util.Log;

import com.example.library.presenter.BasePresenter;
import com.example.library.usecase.ObserverBuilder;
import com.example.library.usecase.UseCase;
import com.example.ranzh.lib.test.data.model.TestResponse;
import com.example.ranzh.lib.test.domain.TestUseCase;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.internal.observers.LambdaObserver;

/**
 * Created by ranzh on 1/6/2017.
 */

public final class TestPresenter extends BasePresenter<TestContract.View> implements TestContract.Presenter {

    private final UseCase testUseCase;

    @Inject
    public TestPresenter(@Named(TestUseCase.NAME) UseCase testUseCase, Activity activity) {
        super(activity);
        this.testUseCase = testUseCase;
    }

    @Override
    public void testPres() {
        Log.d("testPres", "testPres");

        LambdaObserver observer = new ObserverBuilder<TestResponse>()
                .onSuccess(res -> Log.d("res", res.getData().getApi_base_url()))
                .build();

        testUseCase.execute(observer);
        getView().testView();
    }

    @Override
    public void cancel() {
        testUseCase.dispose();
    }
}
