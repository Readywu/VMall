package cn.a17xiezuo.xzlibrary.net;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import okhttp3.OkHttpClient;

/**
 * Created by wuyunan on 16/6/23.
 */
public class VMallVolley {

    private static RequestQueue requestQueue;

    public static RequestQueue getInstance(Context context) {
        if (requestQueue == null) {
            OkHttpClient okClient = new OkHttpClient.Builder().build();
            requestQueue = Volley.newRequestQueue(context, new OkHttpStack(okClient));
            ;
        }
        return requestQueue;
    }
}
