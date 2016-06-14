package com.zzu.commen.frame.vu;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.zzu.commen.frame.Command;

/**
 * Created by lpp on 2016/6/13.
 */
public interface FragmentVu<P extends Command> extends Vu<P> {
    /**
     * 设置和view绑定的Fragment
     *
     * @param fragment 目标Fragment
     */
    <A extends Fragment> void setFragment(A fragment);

    void onCreated();

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void onDestroyView();

    void onCreateOptionsMenu(Menu menu, MenuInflater inflater);

    void onOptionsItemSelected(MenuItem item);
}
