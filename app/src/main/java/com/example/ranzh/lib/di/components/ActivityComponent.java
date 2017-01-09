package com.example.ranzh.lib.di.components;

import android.app.Activity;

import com.example.library.di.PerActivity;
import com.example.ranzh.lib.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by ranzh on 1/9/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();

}
