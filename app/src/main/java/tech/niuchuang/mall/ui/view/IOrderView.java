package tech.niuchuang.mall.ui.view;

/**
 * Created by wuyunan on 16/6/23.
 */
public interface IOrderView extends BaseView {
    void showProgress();

    void hideProgress();

    void showMessage(String message);
}
