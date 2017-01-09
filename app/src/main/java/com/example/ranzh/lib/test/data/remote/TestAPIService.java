package com.example.ranzh.lib.test.data.remote;

import com.example.ranzh.lib.test.data.model.TestResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ranzh on 1/9/2017.
 */

public class TestAPIService {

    private final ITestAPI testAPI;

    @Inject
    public TestAPIService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://b2cglobaluat.englishtown.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        testAPI = retrofit.create(ITestAPI.class);
    }

    public Observable<TestResponse> getStart() {
        return testAPI.bootstrap();
    }

}
