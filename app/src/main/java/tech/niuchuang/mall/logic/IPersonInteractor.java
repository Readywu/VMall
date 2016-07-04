package tech.niuchuang.mall.logic;

import android.content.Context;

import tech.niuchuang.mall.entity.Person;

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
