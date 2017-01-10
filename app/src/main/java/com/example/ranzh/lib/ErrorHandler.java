package com.example.ranzh.lib;

import com.example.library.exception.IErrorHandler;

import javax.inject.Inject;


public class ErrorHandler implements IErrorHandler {

    @Inject
    ErrorHandler() {
    }

    @Override
    public String getErrorMessage(Throwable throwable) {
        throwable.printStackTrace();
        return "ThrowableThrowableThrowableThrowableThrowable";
    }
}
