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
import tech.niuchuang.mall.Presenter.IServiceFragmentPresenter;
import tech.niuchuang.mall.Presenter.impl.ServiceFragmentPresenterImpl;
import tech.niuchuang.mall.R;
import tech.niuchuang.mall.entity.Person;
import tech.niuchuang.mall.ui.view.IServiceView;


/**
 * A placeholder fragment containing a simple view.
 */
public class ServiceFragment extends Fragment implements IServiceView {

    @BindView(R.id.hello)
    TextView helloTextView;
    @BindView(R.id.button)
    Button getInfoButton;

    private Unbinder unbinder;
    IServiceFragmentPresenter serviceFragmentPresenter;

    public static ServiceFragment newInstance() {
        ServiceFragment fragment = new ServiceFragment();
        return fragment;
    }

    public ServiceFragment() {
        serviceFragmentPresenter = new ServiceFragmentPresenterImpl(getContext(), this);
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

        serviceFragmentPresenter.getPersionInfo();
    }

    @OnClick(R.id.button)
    public void getInfo(Button button) {
        serviceFragmentPresenter.getPersionInfo();
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
