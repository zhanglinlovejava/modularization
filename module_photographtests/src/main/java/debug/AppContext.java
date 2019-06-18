package debug;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by zhanglin on 2018/1/5.
 */
public class AppContext extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.printStackTrace();
        ARouter.init(this);
    }
}
