package tech.niuchuang.mall.logic;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import tech.niuchuang.mall.entity.Person;
import tech.niuchuang.xzlibrary.net.HttpRequest;
import tech.niuchuang.xzlibrary.net.IHttpListener;
import tech.niuchuang.xzlibrary.net.VolleyManager;

/**
 * Created by wuyunan on 16/6/23.
 */
public class TestVolley {

    private static final String TAG = "TestVolley";
    private final Context context;

    public TestVolley(Context context) {
        this.context = context;
    }


    public void getSimpleData() {


        HttpRequest httpRequest = new HttpRequest.Builder("http://www.mocky.io/v2/56c9d8c9110000c62f4e0bb0")
                .setMethod(Request.Method.GET)
                .build();
        VolleyManager.getInstance(context).gsonRequest(Person.class, httpRequest, new IHttpListener<Person>() {
            @Override
            public void onSuccess(Person person) {
                Log.d(TAG, "first_name: " + person.getFirstName());
                Log.d(TAG, "last_name: " + person.getLastName());
                Log.d(TAG, "gender: " + person.getGender());
            }

            @Override
            public void onError(VolleyError error) {

            }
        }, this);
    }
}
