package com.example.ranzh.lib.test.domain;

import android.util.Log;

import com.example.library.usecase.UseCase;
import com.example.library.usecase.executor.ExecutionThread;
import com.example.ranzh.lib.test.data.ITestRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by ranzh on 1/9/2017.
 */

public class TestUseCase extends UseCase {

    public static final String NAME = "TestUseCase";

    @Inject
    ITestRepository repository;

    @Inject
    public TestUseCase(@com.example.library.di.JobThread ExecutionThread executionThread,
                       @com.example.library.di.UIThread ExecutionThread postExecutionThread) {
        super(executionThread, postExecutionThread);
    }

    @Override
    protected Observable buildUseCaseObservable(Object... params) {
        Log.d("buildUseCaseObservable", "buildUseCaseObservable");
        return repository.getTestString();
    }
}
