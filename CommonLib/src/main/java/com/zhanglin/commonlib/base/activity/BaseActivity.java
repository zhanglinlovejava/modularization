package com.zhanglin.commonlib.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by zhanglin on 2018/1/12.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(setLayoutId());
        initUIAndData();
    }

    public abstract void initUIAndData();

    public abstract int setLayoutId();

}
