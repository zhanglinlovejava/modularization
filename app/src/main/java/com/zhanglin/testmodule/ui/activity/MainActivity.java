package com.zhanglin.testmodule.ui.activity;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhanglin.commonlib.base.activity.BaseActivity;
import com.zhanglin.testmodule.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    public void initUIAndData() {
        findViewById(R.id.tvZhihuModule).setOnClickListener(this);
        findViewById(R.id.tvBookModule).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvZhihuModule:
                ARouter.getInstance().build("/zhihu/newsActivity").navigation();
                break;
        }

    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

}
