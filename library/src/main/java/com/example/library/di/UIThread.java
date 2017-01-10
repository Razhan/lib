package com.example.library.di;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ranzh on 1/10/2017.
 */

@Qualifier
@Retention(RUNTIME)
public @interface UIThread {
}