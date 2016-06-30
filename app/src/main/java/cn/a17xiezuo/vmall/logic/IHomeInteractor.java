package cn.a17xiezuo.vmall.logic;

import android.content.Context;

import cn.a17xiezuo.vmall.entity.Datum;
import cn.a17xiezuo.vmall.entity.Person;

/**
 * Created by wuyunan on 16/6/27.
 */
public interface IHomeInteractor {
    interface OnFetchHomeDataFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(Person person);

        void onFetchHomeDataSuccess(Datum datum);
    }

    void getPersonInfo(Context context, OnFetchHomeDataFinishedListener listener);

    void getHomeData(Context context, OnFetchHomeDataFinishedListener listener);
}
