package com.example.ranzh.lib.test.data.remote;

import com.example.ranzh.lib.test.data.model.TestResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ranzh on 1/9/2017.
 */

public interface ITestAPI {

    @GET("/api/onthemove/bootstrap")
    Observable<TestResponse> bootstrap();

}
