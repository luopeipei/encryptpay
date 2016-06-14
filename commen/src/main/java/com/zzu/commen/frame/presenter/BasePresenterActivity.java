package com.zzu.commen.frame.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.zzu.commen.frame.ActivityContoller;
import com.zzu.commen.frame.vu.ActivityVu;
import com.zzu.commen.frame.Command;

/**
 * Created by lpp on 2016/6/13.
 * <p/>
 * 通用Activity相关的Presenter
 */
public abstract class BasePresenterActivity<P extends Command, V extends ActivityVu> extends AppCompatActivity {
    private V vu;

    public V getVu() {
        return vu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            preBindView(savedInstanceState);
            //初始化View
            vu = getVuClass().newInstance();
            //设置view对业务的调用句柄
            vu.setCommand(getCommand());
            //设置和View关联的Activity
            vu.setActivity(this);
            vu.init(getLayoutInflater(), null);

            setContentView(vu.getView());
            vu.onCreated();
            if (isAdd2stack()) {
                ActivityContoller.getInstanse().addActivity(this);
            }

            onBindView(savedInstanceState);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        ActivityContoller.getInstanse().removeActivity(this);
        vu.onDestroy();
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        vu.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        vu.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        vu.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        vu.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        vu.onStop();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        vu.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        vu.onDetachedFromWindow();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        vu.onCreateOptionsMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        vu.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        vu.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    protected abstract Class<? extends V> getVuClass();

    protected abstract P getCommand();

    protected void preBindView(Bundle savedInstanceState) {

    }

    protected void onBindView(Bundle savedInstanceState) {

    }

    /**
     * 是否将该Activity加入堆栈中
     */
    protected boolean isAdd2stack() {
        return true;
    }
}
