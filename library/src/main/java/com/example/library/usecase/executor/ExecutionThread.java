package com.example.library.usecase.executor;

import io.reactivex.Scheduler;


public interface ExecutionThread {

    Scheduler getScheduler();

}
