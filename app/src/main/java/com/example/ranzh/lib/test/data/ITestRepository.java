package com.example.ranzh.lib.test.data;

import com.example.ranzh.lib.test.data.model.TestResponse;

import io.reactivex.Observable;

/**
 * Created by ranzh on 1/9/2017.
 */

public interface ITestRepository {

    Observable<TestResponse> getTestString();

}
