package tech.niuchuang.mall.logic.impl;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;

import tech.niuchuang.mall.application.VMallApplication;
import tech.niuchuang.mall.entity.Person;
import tech.niuchuang.mall.logic.IPersonInteractor;
import tech.niuchuang.xzlibrary.net.HttpRequest;
import tech.niuchuang.xzlibrary.net.IHttpListener;
import tech.niuchuang.xzlibrary.net.VolleyManager;

/**
 * Created by wuyunan on 16/6/27.
 */
public class PersonInteractorImpl implements IPersonInteractor {


    private static final String TAG = PersonInteractorImpl.class.getSimpleName();

    private VolleyManager volleyManager;

    public PersonInteractorImpl() {
        this.volleyManager = VolleyManager.getInstance(VMallApplication.getInstance().getApplicationContext());
    }

    @Override
    public void getPersonInfo(Context context, final OnPersonFinishedListener listener) {
        HttpRequest httpRequest = new HttpRequest.Builder("http://www.mocky.io/v2/56c9d8c9110000c62f4e0bb0")
                .setMethod(Request.Method.GET)
                .build();
        volleyManager.gsonRequest(Person.class, httpRequest, new IHttpListener<Person>() {
            @Override
            public void onSuccess(Person person) {
                Log.d(TAG, "first_name: " + person.getFirstName());
                Log.d(TAG, "last_name: " + person.getLastName());
                Log.d(TAG, "gender: " + person.getGender());
                person.setFirstName(person.getFirstName() + System.currentTimeMillis());
                listener.onSuccess(person);
            }

            @Override
            public void onError(VolleyError error) {

            }
        }, this);
    }
}
