package com.example.ranzh.lib.di.modules;

import android.content.Context;

import com.example.library.usecase.executor.ExecutionThread;
import com.example.library.usecase.executor.JobThread;
import com.example.library.usecase.executor.UIThread;
import com.example.ranzh.lib.AndroidApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ranzh on 1/6/2017.
 */

@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    @com.example.library.di.JobThread
    ExecutionThread provideThreadExecutor(JobThread jobThread) {
        return jobThread;
    }

    @Provides
    @Singleton
    @com.example.library.di.UIThread
    ExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}
