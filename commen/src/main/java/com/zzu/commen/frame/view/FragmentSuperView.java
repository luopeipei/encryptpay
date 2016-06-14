package com.zzu.commen.frame.view;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.zzu.commen.frame.Command;
import com.zzu.commen.frame.vu.FragmentVu;

/**
 * Created by lpp on 2016/6/13.
 */
public class FragmentSuperView<T extends Command> extends SuperView<T> implements FragmentVu<T> {
    private Fragment fragment;

    @Override
    public <A extends Fragment> void setFragment(A fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }

    @Override
    public void onCreated() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public void onOptionsItemSelected(MenuItem item) {

    }
}
