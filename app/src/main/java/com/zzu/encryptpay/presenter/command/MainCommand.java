package com.zzu.encryptpay.presenter.command;

import com.zzu.commen.frame.Command;

/**
 * Created by lpp on 2016/6/14.
 */
public interface MainCommand extends Command {

    /**
     * 显示 Toast 提示信息
     * @param msg
     */
    void showToastMessage(int msg);

    /**
     * 打开支付页面
     */
    void openPayActivity();
}
