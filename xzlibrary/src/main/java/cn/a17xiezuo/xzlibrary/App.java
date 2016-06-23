package cn.a17xiezuo.xzlibrary;

import android.app.Application;
import android.content.Context;

/**
 * Created by wuyunan on 16/6/23.
 */
public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
