package com.example.ranzh.lib.di.components;

import android.content.Context;

import com.example.library.exception.IErrorHandler;
import com.example.library.usecase.executor.ExecutionThread;
import com.example.ranzh.lib.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ranzh on 1/6/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Context context();

    @com.example.library.di.JobThread
    ExecutionThread executionThread();

    @com.example.library.di.UIThread
    ExecutionThread postExecutionThread();

    IErrorHandler errorHandler();

}
