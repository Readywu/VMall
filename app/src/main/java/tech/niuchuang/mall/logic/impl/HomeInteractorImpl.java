package tech.niuchuang.mall.logic.impl;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import tech.niuchuang.mall.application.VMallApplication;
import tech.niuchuang.mall.entity.Datum;
import tech.niuchuang.mall.entity.Destination;
import tech.niuchuang.mall.entity.Event;
import tech.niuchuang.mall.entity.MoreExplore;
import tech.niuchuang.mall.entity.Person;
import tech.niuchuang.mall.entity.Scenario;
import tech.niuchuang.mall.entity.Topic;
import tech.niuchuang.mall.logic.IHomeInteractor;
import tech.niuchuang.xzlibrary.net.HttpRequest;
import tech.niuchuang.xzlibrary.net.IHttpListener;
import tech.niuchuang.xzlibrary.net.VolleyManager;

/**
 * Created by wuyunan on 16/6/27.
 */
public class HomeInteractorImpl implements IHomeInteractor {


    private static final String TAG = HomeInteractorImpl.class.getSimpleName();

    private VolleyManager volleyManager;

    public HomeInteractorImpl() {
        this.volleyManager = VolleyManager.getInstance(VMallApplication.getInstance().getApplicationContext());
    }

    @Override
    public void getPersonInfo(Context context, final OnFetchHomeDataFinishedListener listener) {
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

    @Override
    public void getHomeData(Context context, final OnFetchHomeDataFinishedListener listener) {
        String Url = "http://www.xiaohongshu.com/api/sns/v3/explore/banner?" +
                "deviceId=C77494C8-A793-4B22-AFAC-188E9B587DDC&" +
                "lang=zh&platform=iOS&sid=session.1151752893303674146&" +
                "sign=44c418d85a4178efd3cea8b267493681&t=1467256936&tab_mode=0";
        HttpRequest httpRequest = new HttpRequest.Builder(Url)
                .setMethod(Request.Method.GET)
                .build();
        volleyManager.jsonObjectRequest(httpRequest, new IHttpListener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject response) {
                Datum datum1 = new Datum();
                Log.d(TAG, "first_name: " + response.toString());
                try {

                    JSONArray jsonArray = response.getJSONArray("data");
                    if (response.has("data"))

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String type = object.getString("type");
                            Log.d(TAG, type);
                            Gson gson = new Gson();
                            if ("events".equals(type)) {

                                Type listType = new TypeToken<List<Event>>() {
                                }.getType();
                                List<Event> eventList = gson.fromJson(object.getJSONArray(type).toString(), listType);
                                datum1.setEvents(eventList);


                            } else if ("more_explores".equals(type)) {
                                Type listType = new TypeToken<List<MoreExplore>>() {
                                }.getType();
                                List<MoreExplore> list = gson.fromJson(object.getJSONArray(type).toString(), listType);
                                datum1.setMoreExplores(list);
                            } else if ("topic".equals(type)) {
                                Type listType = new TypeToken<List<Topic>>() {
                                }.getType();
                                List<Topic> list = gson.fromJson(object.getJSONArray(type).toString(), listType);
                                datum1.setTopic(list);
                            } else if ("scenario".equals(type)) {
                                Type listType = new TypeToken<List<Scenario>>() {
                                }.getType();
                                List<Scenario> list = gson.fromJson(object.getJSONArray(type).toString(), listType);
                                datum1.setScenario(list);
                            } else if ("destination".equals(type)) {
                                Type listType = new TypeToken<List<Destination>>() {
                                }.getType();
                                List<Destination> list = gson.fromJson(object.getJSONArray(type).toString(), listType);
                                datum1.setDestination(list);
                            } else if ("recommends".equals(type)) {

                            } else if ("boards".equals(type)) {

                            } else if ("brands".equals(type)) {

                            }

                        }
                    Log.d(TAG, datum1.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listener.onFetchHomeDataSuccess(datum1);
            }

            @Override
            public void onError(VolleyError error) {

            }
        }, this);
    }
}
