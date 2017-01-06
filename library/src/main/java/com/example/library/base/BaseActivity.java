package com.example.library.base;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.library.R;

import butterknife.ButterKnife;

/**
 * Created by ranzh on 1/4/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements InitView {

    protected final String TAG = this.getClass().getSimpleName();

    protected boolean translucentStatusBar = false;
    protected boolean screenRotate = false;
    protected boolean fullScreen = false;
    protected boolean doubleClickExit = false;
    protected boolean immersiveMode = false;

    private boolean BackPressedOnce = false;

    @Override
    @CallSuper
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beforeInitView();
        setContentView(getContentViewId());
        ButterKnife.bind(this);

        initData();
        initView(savedInstanceState);
    }

    private void beforeInitView() {
        if (!screenRotate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        if (fullScreen) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        if (translucentStatusBar && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void initData() {

    }

    @CallSuper
    @Override
    public void initView(Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar == null) {
            return;
        }

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showBackIcon());
        getSupportActionBar().setTitle(setToolBarText());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    protected boolean showBackIcon() {
        return true;
    }

    abstract protected String setToolBarText();

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (immersiveMode && hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void onBackPressed() {
        if (!doubleClickExit) {
            super.onBackPressed();
            return;
        }

        if (BackPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.BackPressedOnce = true;

        showToast(getString(R.string.double_confirm));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BackPressedOnce = false;
            }
        }, 2000);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int id) {
        showToast(getString(id));
    }

    public void setTranslucentStatusBar(boolean translucentStatusBar) {
        this.translucentStatusBar = translucentStatusBar;
    }

    public void setScreenRotate(boolean screenRotate) {
        this.screenRotate = screenRotate;
    }

    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }

    public void setDoubleClickExit(boolean doubleClickExit) {
        this.doubleClickExit = doubleClickExit;
    }

    public void setImmersiveMode(boolean immersiveMode) {
        this.immersiveMode = immersiveMode;
    }

}