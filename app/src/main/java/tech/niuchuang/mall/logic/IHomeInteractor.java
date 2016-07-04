package tech.niuchuang.mall.logic;

import android.content.Context;

import tech.niuchuang.mall.entity.Datum;
import tech.niuchuang.mall.entity.Person;

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
