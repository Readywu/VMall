package cn.a17xiezuo.vmall.logic;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import cn.a17xiezuo.xzlibrary.net.VMallVolley;

/**
 * Created by wuyunan on 16/6/23.
 */
public class TestVolley {

    private final Context context;
    private RequestQueue requestQueue;

    public TestVolley(Context context) {
        this.context = context;
        requestQueue = VMallVolley.getInstance(context);
    }


    public void getSimpleData() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://www.mocky.io/v2/56c9d8c9110000c62f4e0bb0", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("mTAG", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("mTAG", error.getMessage(), error);
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
