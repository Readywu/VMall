package tech.niuchuang.xzlibrary;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by wuyunan on 16/6/23.
 */
public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        Log.d("app", "dddd");
    }

    public static Context getContext() {
        return sContext;
    }
}
