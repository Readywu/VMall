package cn.a17xiezuo.vmall.ui.view;

/**
 * Created by wuyunan on 16/6/23.
 */
public interface IContactView extends BaseView {
    void showProgress();

    void hideProgress();

    void showMessage(String message);
}
