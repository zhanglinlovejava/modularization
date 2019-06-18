package com.zhanglin.testmodule;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhanglin.commonlib.base.app.BaseApplication;

/**
 * Created by zhanglin on 2018/1/5.
 */
public class MainApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.printStackTrace();
        ARouter.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
