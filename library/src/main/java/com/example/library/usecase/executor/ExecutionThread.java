package com.example.library.usecase.executor;

import io.reactivex.Scheduler;

/**
 * Created by ranzh on 1/5/2017.
 */

public interface ExecutionThread {

    Scheduler getScheduler();

}
