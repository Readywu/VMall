package tech.niuchuang.mall.ui.view;

import tech.niuchuang.mall.entity.Person;

/**
 * Created by wuyunan on 16/6/23.
 */
public interface IPersonCenterView extends BaseView {
    void showProgress();

    void hideProgress();

    void setPerson(Person person);

    void showMessage(String message);
}
