package cn.a17xiezuo.vmall.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.a17xiezuo.vmall.Presenter.IMainviewPresenter;
import cn.a17xiezuo.vmall.Presenter.impl.MainviewPresenterImpl;
import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.entity.Person;
import cn.a17xiezuo.vmall.ui.view.IMainView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivity4Fragment extends Fragment implements IMainView {

    @BindView(R.id.hello)
    TextView helloTextView;
    @BindView(R.id.button)
    Button getInfoButton;

    private Unbinder unbinder;
    IMainviewPresenter mainviewPresenter;

    public static MainActivity4Fragment newInstance() {
        MainActivity4Fragment fragment = new MainActivity4Fragment();
        return fragment;
    }

    public MainActivity4Fragment() {
        mainviewPresenter = new MainviewPresenterImpl(getContext(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        mainviewPresenter.getPersionInfo();
    }

    @OnClick(R.id.button)
    public void getInfo(Button button) {
        mainviewPresenter.getPersionInfo();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setPerson(Person person) {
        helloTextView.setText(person.getFirstName());
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
