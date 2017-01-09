package com.example.ranzh.lib.di.modules;

import android.app.Activity;

import com.example.library.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ranzh on 1/9/2017.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
