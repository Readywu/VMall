package tech.niuchuang.mall.Presenter.impl;

import android.content.Context;

import tech.niuchuang.mall.Presenter.IServiceFragmentPresenter;
import tech.niuchuang.mall.entity.Person;
import tech.niuchuang.mall.logic.IPersonInteractor;
import tech.niuchuang.mall.logic.impl.PersonInteractorImpl;
import tech.niuchuang.mall.ui.view.IServiceView;

/**
 * Created by wuyunan on 16/6/27.
 */
public class ServiceFragmentPresenterImpl implements IServiceFragmentPresenter, IPersonInteractor.OnPersonFinishedListener {

    IServiceView mainView;
    IPersonInteractor personInteractor;
    Context mComtext;

    public ServiceFragmentPresenterImpl(Context context, IServiceView mainView) {
        this.mainView = mainView;
        this.personInteractor = new PersonInteractorImpl();
        this.mComtext = context;
    }

    @Override
    public void getPersionInfo() {
        if (mainView != null) {
            mainView.showProgress();
        }
        this.personInteractor.getPersonInfo(mComtext, this);
    }


    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onSuccess(Person person) {
        if (mainView != null) {
            mainView.setPerson(person);
        }
    }

}
