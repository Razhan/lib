package com.example.library.base.ui;

import android.os.Bundle;

public interface InitView {

    int getContentViewId();

    void initData();

    void initView(Bundle savedInstanceState);

}
