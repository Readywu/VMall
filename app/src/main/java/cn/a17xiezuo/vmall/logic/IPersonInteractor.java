package cn.a17xiezuo.vmall.logic;

import android.content.Context;

import cn.a17xiezuo.vmall.entity.Person;

/**
 * Created by wuyunan on 16/6/27.
 */
public interface IPersonInteractor {
    interface OnPersonFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(Person person);
    }

    void getPersonInfo(Context context, OnPersonFinishedListener listener);
}
