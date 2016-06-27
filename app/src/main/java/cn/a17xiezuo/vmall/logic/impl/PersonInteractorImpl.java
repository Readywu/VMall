package cn.a17xiezuo.vmall.logic.impl;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import cn.a17xiezuo.vmall.entity.Person;
import cn.a17xiezuo.vmall.logic.IPersonInteractor;
import cn.a17xiezuo.xzlibrary.net.HttpRequest;
import cn.a17xiezuo.xzlibrary.net.IHttpListener;
import cn.a17xiezuo.xzlibrary.net.VolleyManager;

/**
 * Created by wuyunan on 16/6/27.
 */
public class PersonInteractorImpl implements IPersonInteractor {


    private static final String TAG = PersonInteractorImpl.class.getSimpleName();

    @Override
    public void getPersonInfo(Context context, final OnPersonFinishedListener listener) {
        HttpRequest httpRequest = new HttpRequest.Builder("http://www.mocky.io/v2/56c9d8c9110000c62f4e0bb0")
                .setMethod(Request.Method.GET)
                .build();
        VolleyManager.getInstance(context).gsonRequest(Person.class, httpRequest, new IHttpListener<Person>() {
            @Override
            public void onSuccess(Person person) {
                Log.d(TAG, "first_name: " + person.getFirst_name());
                Log.d(TAG, "last_name: " + person.getLast_name());
                Log.d(TAG, "gender: " + person.getGender());
                listener.onSuccess(person);
            }

            @Override
            public void onError(VolleyError error) {

            }
        }, this);
    }
}
