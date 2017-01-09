package com.example.ranzh.lib.di.modules;

import com.example.library.di.PerActivity;
import com.example.library.usecase.UseCase;
import com.example.ranzh.lib.test.data.ITestRepository;
import com.example.ranzh.lib.test.data.TestRepositoryImp;
import com.example.ranzh.lib.test.domain.TestUseCase;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ranzh on 1/9/2017.
 */

@Module
public class TestModule {

    @Provides
    @PerActivity
    @Named(TestUseCase.NAME)
    UseCase provideTestUseCase(TestUseCase testUseCase) {
        return testUseCase;
    }

    @Provides
    @PerActivity
    ITestRepository provideTestRepository(TestRepositoryImp testRepository) {
        return testRepository;
    }

}
