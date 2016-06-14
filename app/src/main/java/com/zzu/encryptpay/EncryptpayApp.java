package com.zzu.encryptpay;

import android.app.Application;

/**
 * Created by lpp on 2016/6/13.
 */
public class EncryptpayApp extends Application{
    /**
     * Application单例
     */
    private static EncryptpayApp encryptpayApp;

    public static void setEncryptpayApp(EncryptpayApp app) {
        encryptpayApp = app;
    }

    /**
     * 获取Applcation对象
     *
     * @return
     */
    public static EncryptpayApp getEncryptpayApp() {
        if (encryptpayApp == null)
            encryptpayApp = new EncryptpayApp();
        return encryptpayApp;
    }
}
