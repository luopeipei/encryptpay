package com.zzu.encryptpay.presenter.activity;

import android.content.Intent;
import android.widget.Toast;

import com.zzu.encryptpay.presenter.command.MainCommand;
import com.zzu.encryptpay.ui.view.ViewMain;
import com.zzu.encryptpay.ui.vu.MainVu;

/**
 * Created by lpp on 2016/6/14.
 */
public class MainPrensenter extends ActivityPresenter<MainCommand, MainVu> implements MainCommand  {
    @Override
    protected Class<? extends MainVu> getVuClass() {
        return ViewMain.class;
    }

    @Override
    protected MainCommand getCommand() {
        return this;
    }

    @Override
    public void showToastMessage(int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openPayActivity() {
        Intent intent = new Intent();
        intent.setClass(this,ActivityPay.class);
        startActivity(intent);
    }
}
