package com.example.library.base;

import android.content.Context;

/**
 * Created by ranzh on 1/5/2017.
 */

public interface MVPView {

    void showMessage(String msg);

    Context context();

}
