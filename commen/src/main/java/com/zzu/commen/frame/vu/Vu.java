package com.zzu.commen.frame.vu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzu.commen.frame.Command;

/**
 * MVP模式中View层的通用接口
 *
 * Created by lpp on 2016/6/13.
 */
public interface Vu<P extends Command> {
    /**
     * 初始化View
     *
     * @param inflater  布局加载对象
     * @param container View容器
     */
    void init(LayoutInflater inflater, ViewGroup container);

    /**
     * 获取View层整体对象
     *
     * @return
     */
    View getView();

    /**
     * 设置View操作Presenter的接口
     *
     * @param command 目标接口
     */
    void setCommand(P command);

    /**
     * 设置和View相关的Activity
     *
     * @param activity 目标Activity
     * @param <A>
     */
    <A extends Activity> void setActivity(A activity);
}
