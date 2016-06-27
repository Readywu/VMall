package cn.a17xiezuo.vmall.application;

import android.app.Application;

import com.squareup.leakcanary.RefWatcher;
import com.squareup.leakcanary.LeakCanary;

import cn.a17xiezuo.xzlibrary.net.VolleyManager;
import cn.a17xiezuo.xzlibrary.utils.Log;

/**
 * Created by wuyunan on 16/6/17.
 */
public class VMallApplication extends Application {


    private RefWatcher mRefWatcher;

    private static VMallApplication instance;

    public static VMallApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        LeakCanary.install(this);
        Log.d("ddddd", "ddffkdkfd");
        VolleyManager.INSTANCE.init(this);

    }


}
