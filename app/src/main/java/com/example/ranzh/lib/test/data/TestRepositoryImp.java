package com.example.ranzh.lib.test.data;

import com.example.ranzh.lib.test.data.model.TestResponse;
import com.example.ranzh.lib.test.data.remote.TestAPIService;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by ranzh on 1/9/2017.
 */

public class TestRepositoryImp implements ITestRepository {

    private final TestAPIService remoteService;

    @Inject
    public TestRepositoryImp(TestAPIService remoteService) {
        this.remoteService = remoteService;
    }

    @Override
    public Observable<TestResponse> getTestString() {
        return remoteService.getStart();
    }


}

