package com.zzu.encryptpay.ui.view;

import android.widget.Button;

import com.zzu.commen.frame.annotation.ContentView;
import com.zzu.commen.frame.view.ActivityView;
import com.zzu.encryptpay.R;
import com.zzu.encryptpay.presenter.command.MainCommand;
import com.zzu.encryptpay.ui.vu.MainVu;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lpp on 2016/6/14.
 */

@ContentView(value = R.layout.activity_main)
public class ViewMain extends ActivityView<MainCommand> implements MainVu {
    @InjectView(R.id.button)
    Button button;

    @OnClick(R.id.button)
    public void clickButton(){
        getCommand().showToastMessage(R.string.show_tosat);
        getCommand().openPayActivity();
    }
}
