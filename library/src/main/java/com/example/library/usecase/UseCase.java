package com.example.library.usecase;

import com.example.library.usecase.executor.ExecutionThread;
import com.example.library.usecase.executor.PostExecutionThread;

import io.reactivex.Observable;
import io.reactivex.internal.observers.LambdaObserver;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ranzh on 1/5/2017.
 */

public abstract class UseCase {

    private final PostExecutionThread postExecutionThread;
    private final ExecutionThread executionThread;
    private LambdaObserver disposable;

    public UseCase(ExecutionThread executionThread, PostExecutionThread postExecutionThread) {
        this.executionThread = executionThread;
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract Observable buildUseCaseObservable(Object... params);

    @SuppressWarnings("unchecked")
    public void execute(LambdaObserver observer, Object... params) {
        this.disposable = observer;

        this.buildUseCaseObservable(params)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(observer);
    }

    public void dispose() {
        checkNotNull(disposable);

        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }

}
