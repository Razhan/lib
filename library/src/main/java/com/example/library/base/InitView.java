package com.example.library.base;

import android.os.Bundle;

/**
 * Created by ranzh on 1/4/2017.
 */

public interface InitView {

    int getContentViewId();

    void initData();

    void initView(Bundle savedInstanceState);

}
