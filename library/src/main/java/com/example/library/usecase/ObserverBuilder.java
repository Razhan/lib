package com.example.library.usecase;

import com.example.library.exception.ErrorMessageHandler;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.LambdaObserver;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ranzh on 1/5/2017.
 */

public final class ObserverBuilder<T> {

    private static ErrorMessageHandler errorHandler;

    private Consumer<T> onSuccessCallback;
    private Consumer<Throwable> onErrorCallback;
    private Action onCompleteCallback;

    public ObserverBuilder() {
        onSuccessCallback = Functions.emptyConsumer();
        onErrorCallback = new Consumer<Throwable>() {
            @Override
            public void accept(Throwable error) {
                errorHandler.create(error);
            }
        };
        onCompleteCallback = Functions.EMPTY_ACTION;
    }

    public ObserverBuilder onSuccess(Consumer<T> consumer) {
        checkNotNull(consumer);
        onSuccessCallback = consumer;
        return this;
    }

    public ObserverBuilder onError(Consumer<Throwable> consumer) {
        checkNotNull(consumer);
        onErrorCallback = consumer;
        return this;
    }

    public ObserverBuilder onComplete(Action action) {
        checkNotNull(action);
        onCompleteCallback = action;
        return this;
    }

    public LambdaObserver<T> build() {
        return new LambdaObserver<>(
                onSuccessCallback,
                onErrorCallback,
                onCompleteCallback,
                Functions.emptyConsumer()
        );
    }

}