package com.example.ranzh.lib.di.components;

import android.content.Context;

import com.example.library.usecase.executor.ExecutionThread;
import com.example.library.usecase.executor.PostExecutionThread;
import com.example.ranzh.lib.di.modules.ApplicationModule;
import com.example.ranzh.lib.test.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ranzh on 1/6/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainActivity baseActivity);


    Context context();
    ExecutionThread executionThread();
    PostExecutionThread postExecutionThread();
}
