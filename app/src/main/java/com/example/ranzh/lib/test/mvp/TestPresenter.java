package com.example.ranzh.lib.test.mvp;

import android.app.Activity;
import android.util.Log;

import com.example.library.presenter.BasePresenter;
import com.example.library.usecase.UseCaseBuilder;
import com.example.library.usecase.UseCase;
import com.example.ranzh.lib.test.data.model.TestResponse;
import com.example.ranzh.lib.test.domain.TestUseCase;

import javax.inject.Inject;
import javax.inject.Named;

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
    public void testPres(String str) {
        Log.d("testPres", "testPres");

        new UseCaseBuilder<TestResponse>(testUseCase)
                .onSuccess(res -> {
                    Log.d("res", res.getData().getApi_base_url());
                    getView().testView();
                })
                .onError(this::showErrorMessage)
                .build(str);
    }

    @Override
    public void cancel() {
        testUseCase.dispose();
    }
}
