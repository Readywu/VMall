package cn.a17xiezuo.vmall.Presenter.impl;

import android.content.Context;

import cn.a17xiezuo.vmall.Presenter.IHomePresenter;
import cn.a17xiezuo.vmall.entity.Datum;
import cn.a17xiezuo.vmall.entity.Person;
import cn.a17xiezuo.vmall.logic.IHomeInteractor;
import cn.a17xiezuo.vmall.logic.impl.HomeInteractorImpl;
import cn.a17xiezuo.vmall.ui.view.IHomeView;

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
