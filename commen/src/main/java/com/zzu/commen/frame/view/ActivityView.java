package com.zzu.commen.frame.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zzu.commen.frame.Command;

/**
 * Created by lpp on 2016/6/13.
 *
 * 在此可初始化toolbar控件
 *
 * 业务Activity的View基类
 */
public class ActivityView<T extends Command> extends ActivitySuperView<T> {

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        super.init(inflater, container);
    }

    @Override
    public void onCreated() {
        super.onCreated();
    }
}
