package com.example.ranzh.lib;

import android.app.Application;

import com.example.ranzh.lib.di.components.ApplicationComponent;
import com.example.ranzh.lib.di.components.DaggerApplicationComponent;
import com.example.ranzh.lib.di.modules.ApplicationModule;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }


}
