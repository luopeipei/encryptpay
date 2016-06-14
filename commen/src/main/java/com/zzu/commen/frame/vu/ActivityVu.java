package com.zzu.commen.frame.vu;

import android.view.Menu;
import android.view.MenuItem;

import com.zzu.commen.frame.Command;

/**
 * Created by lpp on 2016/6/13.
 *
 * 和Acitivity生命周期相关的View层的生命周期定义
 */
public interface ActivityVu<P extends Command> extends Vu<P> {

    void onCreated();

    void onResume();

    void onStart();

    void onRestart();

    void onPause();

    void onStop();

    void onDestroy();

    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onCreateOptionsMenu(Menu menu);

    void onOptionsItemSelected(MenuItem item);

    void onPrepareOptionsMenu(Menu menu);
}
