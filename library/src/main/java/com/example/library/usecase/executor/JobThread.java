package com.example.library.usecase.executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ranzh on 1/6/2017.
 */

@Singleton
public class JobThread implements ExecutionThread {

    @Inject
    JobThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return Schedulers.newThread();
    }

}