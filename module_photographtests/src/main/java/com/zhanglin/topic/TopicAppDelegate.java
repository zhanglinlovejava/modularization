package com.zhanglin.topic;

import com.zhanglin.commonlib.base.app.IApplicationDelegate;
import com.zhanglin.commonlib.utils.Logger;

/**
 * Created by zhanglin on 2019/6/18.
 */
public class TopicAppDelegate implements IApplicationDelegate {
    @Override
    public void onCreate() {
        Logger.e( "---------on topic app create");
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
