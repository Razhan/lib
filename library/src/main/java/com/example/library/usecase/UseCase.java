package com.example.library.usecase;

import com.example.library.usecase.executor.ExecutionThread;
import com.example.library.usecase.executor.PostExecutionThread;

import io.reactivex.Observable;
import io.reactivex.internal.observers.LambdaObserver;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ranzh on 1/5/2017.
 */

public abstract class UseCase<T> {

    private final PostExecutionThread postExecutionThread;
    private final ExecutionThread executionThread;
    private LambdaObserver disposable;

    public UseCase(PostExecutionThread postExecutionThread, ExecutionThread executionThread) {
        this.postExecutionThread = postExecutionThread;
        this.executionThread = executionThread;
    }

    protected abstract Observable<T> buildUseCaseObservable(Object... params);

    public void execute(LambdaObserver<T> observer, Object... params) {
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
