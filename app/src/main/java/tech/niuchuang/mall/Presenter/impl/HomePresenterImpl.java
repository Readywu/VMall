package tech.niuchuang.mall.Presenter.impl;

import android.content.Context;

import tech.niuchuang.mall.Presenter.IHomePresenter;
import tech.niuchuang.mall.entity.Datum;
import tech.niuchuang.mall.entity.Person;
import tech.niuchuang.mall.logic.IHomeInteractor;
import tech.niuchuang.mall.logic.impl.HomeInteractorImpl;
import tech.niuchuang.mall.ui.view.IHomeView;

/**
 * Created by wuyunan on 16/6/27.
 */
public class HomePresenterImpl implements IHomePresenter, IHomeInteractor.OnFetchHomeDataFinishedListener {

    IHomeView homeView;
    IHomeInteractor homeInteractor;
    Context mComtext;

    public HomePresenterImpl(Context context, IHomeView mainView) {
        this.homeView = mainView;
        this.homeInteractor = new HomeInteractorImpl();
        this.mComtext = context;
    }

    @Override
    public void getHomeData() {
        if (homeView != null) {
            homeView.showProgress();
        }
        this.homeInteractor.getHomeData(mComtext, this);
    }


    @Override
    public void onDestroy() {
        homeView = null;
    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onSuccess(Person person) {
        if (homeView != null) {
            homeView.setPerson(person);
        }
    }

    @Override
    public void onFetchHomeDataSuccess(Datum datum) {
        homeView.refreshData(datum);
    }

}
