package com.example.library.exception;

/**
 * Created by ranzh on 1/6/2017.
 */

public interface ErrorMessageHandler {

    String create(Throwable throwable);

}
