package com.zzu.encryptpay.presenter.activity;

import com.zzu.commen.frame.Command;
import com.zzu.commen.frame.presenter.BasePresenterActivity;
import com.zzu.commen.frame.vu.ActivityVu;

/**
 * 业务相关的Activity的Presenter
 */

public abstract class ActivityPresenter<P extends Command, V extends ActivityVu> extends BasePresenterActivity<P,V> {

}
