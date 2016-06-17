package cn.a17xiezuo.vmall.application;

import android.app.Application;

import com.squareup.leakcanary.RefWatcher;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by wuyunan on 16/6/17.
 */
public class VMallApplication extends Application {


    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);

    }
}
