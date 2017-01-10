package com.example.ranzh.lib.test.mvp;

import com.example.library.base.ui.MVPView;
import com.example.library.presenter.IPresenter;

/**
 * Created by ranzh on 1/6/2017.
 */

public interface TestContract {

    interface View extends MVPView {

        void testView();
    }

    interface Presenter extends IPresenter {

        void testPres(String str);
    }

}
