package tech.niuchuang.mall.Presenter.impl;

import android.content.Context;

import tech.niuchuang.mall.Presenter.IPersonCenterPresenter;
import tech.niuchuang.mall.entity.Person;
import tech.niuchuang.mall.logic.IPersonInteractor;
import tech.niuchuang.mall.logic.impl.PersonInteractorImpl;
import tech.niuchuang.mall.ui.view.IPersonCenterView;

/**
 * Created by wuyunan on 16/6/27.
 */
public class PersonCenterFragmentPresenterImpl implements IPersonCenterPresenter, IPersonInteractor.OnPersonFinishedListener {

    IPersonCenterView personCenterView;
    IPersonInteractor personInteractor;
    Context mComtext;

    public PersonCenterFragmentPresenterImpl(Context context, IPersonCenterView mainView) {
        this.personCenterView = mainView;
        this.personInteractor = new PersonInteractorImpl();
        this.mComtext = context;
    }

    @Override
    public void getPersionInfo() {
        if (personCenterView != null) {
            personCenterView.showProgress();
        }
        this.personInteractor.getPersonInfo(mComtext, this);
    }


    @Override
    public void onDestroy() {
        personCenterView = null;
    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onSuccess(Person person) {
        if (personCenterView != null) {
            personCenterView.setPerson(person);
        }
    }

}
