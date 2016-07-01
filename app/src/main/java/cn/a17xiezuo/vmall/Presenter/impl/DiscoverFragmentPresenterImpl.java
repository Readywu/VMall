package cn.a17xiezuo.vmall.Presenter.impl;

import android.content.Context;

import cn.a17xiezuo.vmall.Presenter.IDiscoverFragmentPresenter;
import cn.a17xiezuo.vmall.entity.Datum;
import cn.a17xiezuo.vmall.entity.Person;
import cn.a17xiezuo.vmall.logic.IDiscoverInteractor;
import cn.a17xiezuo.vmall.logic.impl.DiscoverInteractorImpl;
import cn.a17xiezuo.vmall.ui.view.IDiscoverView;

/**
 * Created by wuyunan on 16/6/27.
 */
public class DiscoverFragmentPresenterImpl implements IDiscoverFragmentPresenter, IDiscoverInteractor.OnFetchDiscoverDataFinishedListener {

    IDiscoverView discoverView;
    IDiscoverInteractor discoverInteractor;
    Context mComtext;

    public DiscoverFragmentPresenterImpl(Context context, IDiscoverView mainView) {
        this.discoverView = mainView;
        this.discoverInteractor = new DiscoverInteractorImpl();
        this.mComtext = context;
    }

    @Override
    public void getHomeData() {
        if (discoverView != null) {
            discoverView.showProgress();
        }
        this.discoverInteractor.getHomeData(mComtext, this);
    }


    @Override
    public void onDestroy() {
        discoverView = null;
    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onSuccess(Person person) {
        if (discoverView != null) {
            discoverView.setPerson(person);
        }
    }

    @Override
    public void onFetchDiscoverDataSuccess(Datum datum) {
        discoverView.refreshData(datum);
    }

}
