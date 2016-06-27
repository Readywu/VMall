package cn.a17xiezuo.xzlibrary.net;

import com.android.volley.Response;

/**
 * Created by 大灯泡 on 2016/2/9.
 * 网络请求回掉接口封装
 */
public interface BaseResponseListener {
    void onStart(Response response);

    void onStop(Response response);

    void onFailure(Response response);

    void onSuccess(Response response);
}