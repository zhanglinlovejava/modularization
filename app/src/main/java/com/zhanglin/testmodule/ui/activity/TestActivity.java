package com.zhanglin.testmodule.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhanglin.arouter.RouterPath;
import com.zhanglin.basiccomponent.base.activity.BaseLoadingActivity;


/**
 * Created by zhanglin on 2018/1/8.
 */
@Route(path = RouterPath.PATH_TEST_ACTIVITY)
public class TestActivity extends BaseLoadingActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("宿主 app test activity");
        setContentView(textView);
    }

    @Override
    public void onEmptyOrErrorRetry() {

    }

    @Override
    public void initUIAndData() {

    }

    @Override
    public int setLayoutId() {
        return 0;
    }
}
