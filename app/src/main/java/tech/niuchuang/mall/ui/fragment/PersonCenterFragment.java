package tech.niuchuang.mall.ui.fragment;

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
import tech.niuchuang.mall.Presenter.IPersonCenterPresenter;
import tech.niuchuang.mall.Presenter.impl.PersonCenterFragmentPresenterImpl;
import tech.niuchuang.mall.R;
import tech.niuchuang.mall.entity.Person;
import tech.niuchuang.mall.ui.view.IPersonCenterView;


/**
 * A placeholder fragment containing a simple view.
 */
public class PersonCenterFragment extends Fragment implements IPersonCenterView {

    @BindView(R.id.hello)
    TextView helloTextView;
    @BindView(R.id.button)
    Button getInfoButton;

    private Unbinder unbinder;
    IPersonCenterPresenter personCenterPresenter;

    public static PersonCenterFragment newInstance() {
        PersonCenterFragment fragment = new PersonCenterFragment();
        return fragment;
    }

    public PersonCenterFragment() {
        personCenterPresenter = new PersonCenterFragmentPresenterImpl(getContext(), this);
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

        personCenterPresenter.getPersionInfo();
    }

    @OnClick(R.id.button)
    public void getInfo(Button button) {
        personCenterPresenter.getPersionInfo();
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
