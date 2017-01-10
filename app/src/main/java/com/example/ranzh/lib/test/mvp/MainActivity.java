package com.example.ranzh.lib.test.mvp;

import android.util.Log;
import android.view.View;

import com.example.library.base.BaseMVPActivity;
import com.example.ranzh.lib.AndroidApplication;
import com.example.ranzh.lib.R;
import com.example.ranzh.lib.di.components.DaggerTestComponent;
import com.example.ranzh.lib.di.modules.ActivityModule;

import butterknife.OnClick;

public class MainActivity extends BaseMVPActivity<TestPresenter> implements TestContract.View {

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected String setToolBarText() {
        return "test";
    }

    @Override
    protected void initializeInjector() {
        DaggerTestComponent.builder()
                .applicationComponent(((AndroidApplication) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void testView() {
        Log.d("testView", "testView");
    }

    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Log.d("onClick", "onClick");
                getPresenter().testPres("onClick");
                break;
            case R.id.button2:
                Log.d("onClick2", "onClick2");
                getPresenter().cancel();
                break;
        }
    }

//    @Override
//    public void initView(Bundle savedInstanceState) {
//        super.initView(savedInstanceState);
//
//        findViewById(R.id.button).setOnClickListener(v -> {
//            Log.d("onClick", "onClick");
//            getPresenter().testPres();
//        });
//
//    }


}
