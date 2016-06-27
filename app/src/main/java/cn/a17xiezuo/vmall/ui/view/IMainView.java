package cn.a17xiezuo.vmall.ui.view;

import java.util.List;

import cn.a17xiezuo.vmall.entity.Person;

/**
 * Created by wuyunan on 16/6/23.
 */
public interface IMainView {
    void showProgress();

    void hideProgress();

    void setPerson(Person person);

    void showMessage(String message);
}
