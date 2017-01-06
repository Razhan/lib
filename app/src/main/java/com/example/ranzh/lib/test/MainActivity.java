package com.example.ranzh.lib.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.library.base.BaseMVPActivity;
import com.example.ranzh.lib.R;

public class MainActivity extends BaseMVPActivity<TestPresenter> implements TestContract.View {

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected String setToolBarText() {
        return "test";
    }

    @NonNull
    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter();
    }

    @Override
    public void testView() {
        Log.d("testView", "testView");
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        findViewById(R.id.button).setOnClickListener(v -> {
                Log.d("onClick", "onClick");
                presenter().testPres();
            });

    }

}
