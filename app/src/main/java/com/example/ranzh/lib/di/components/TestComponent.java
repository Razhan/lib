package com.example.ranzh.lib.di.components;

import com.example.library.di.PerActivity;
import com.example.ranzh.lib.di.modules.ActivityModule;
import com.example.ranzh.lib.di.modules.TestModule;
import com.example.ranzh.lib.test.mvp.MainActivity;

import dagger.Component;

/**
 * 0
 * Created by ranzh on 1/9/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, TestModule.class})
public interface TestComponent extends ActivityComponent {

    void inject(MainActivity activity);

}