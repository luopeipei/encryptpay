package com.zzu.commen.frame.view;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.zzu.commen.R;
import com.zzu.commen.circleimageview.CustomDialog;
import com.zzu.commen.frame.vu.ActivityVu;
import com.zzu.commen.frame.Command;

/**
 * Created by lpp on 2016/6/13.
 */
public class ActivitySuperView<T extends Command> extends SuperView<T> implements ActivityVu<T> {

    /**
     * 耗时动画提示框
     */
    private CustomDialog progressDialog;


    @Override
    public void onCreated() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onAttachedToWindow() {

    }

    @Override
    public void onDetachedFromWindow() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu) {

    }

    @Override
    public void onOptionsItemSelected(MenuItem item) {

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

    }

    public FragmentManager getFragmentManager() {
        return ((ActionBarActivity) getActivity()).getSupportFragmentManager();
    }

    /**
     * 显示系统样式的圆形进度对话框
     *
     * @param msg 显示的内容
     */
    public void showCommonProgressDialog(String msg) {
        showCommonProgressDialog(msg, false, true);
    }

    /**
     * 显示耗时动画
     *
     * @param resId
     */
    public void showCommonProgressDialog(int resId) {
        showCommonProgressDialog(getStringRes(resId), false, true);
    }


    /**
     * 显示耗时动画
     */
    public void showCommonProgressDialog(String msg, boolean isTouch, boolean onKey) {
        if (progressDialog == null) {
            progressDialog = new CustomDialog(getContext());
            View view = LayoutInflater.from(getContext()).inflate(R.layout.view_progress_dialog, null);
            progressDialog.setView(view);
        }
        //填写标题
        View view = progressDialog.getView();
        if (view != null) {
            TextView messageView = (TextView) view.findViewById(R.id.dialog_message);
            messageView.setText(msg);
        }
        progressDialog.setCanceledOnTouchOutside(isTouch);
        progressDialog.setCancelable(onKey);
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    /**
     * 修改等待框内容
     *
     * @param msg 显示的内容
     */
    public void changeCommonProgressDialog(String msg) {
        changeCommonProgressDialog(msg, false, true);
    }

    /**
     * 修改等待框内容
     *
     * @param resId
     */
    public void changeCommonProgressDialog(int resId) {
        changeCommonProgressDialog(getStringRes(resId), false, true);
    }

    /**
     * 修改等待框内容
     *
     * @param msg
     * @param isTouch
     * @param onKey
     */
    public void changeCommonProgressDialog(String msg, boolean isTouch, boolean onKey) {
        showCommonProgressDialog(msg, isTouch, onKey);
    }

    /**
     * 取消耗时动画
     */
    public void dismissCommonProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
