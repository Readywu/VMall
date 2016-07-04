package tech.niuchuang.mall.logic;

import android.content.Context;

import tech.niuchuang.mall.entity.Datum;
import tech.niuchuang.mall.entity.Person;

/**
 * Created by wuyunan on 16/6/27.
 */
public interface IDiscoverInteractor {
    interface OnFetchDiscoverDataFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(Person person);

        void onFetchDiscoverDataSuccess(Datum datum);
    }

    void getPersonInfo(Context context, OnFetchDiscoverDataFinishedListener listener);

    void getHomeData(Context context, OnFetchDiscoverDataFinishedListener listener);
}
