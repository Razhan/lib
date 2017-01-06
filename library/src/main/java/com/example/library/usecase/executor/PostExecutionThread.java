package com.example.library.usecase.executor;

import io.reactivex.Scheduler;

/**
 * Created by ranzh on 1/6/2017.
 */

public interface PostExecutionThread {

    Scheduler getScheduler();

}
