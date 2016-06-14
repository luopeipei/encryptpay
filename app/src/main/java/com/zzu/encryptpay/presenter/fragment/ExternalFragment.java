package com.zzu.encryptpay.presenter.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzu.encryptpay.R;

/**
 * Created by lpp on 2016/6/13.
 */
public class ExternalFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pay_external, container, false);
    }
}
