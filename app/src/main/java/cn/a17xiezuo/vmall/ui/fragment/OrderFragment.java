package cn.a17xiezuo.vmall.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.a17xiezuo.vmall.Presenter.IOrderFragmentPresenter;
import cn.a17xiezuo.vmall.Presenter.impl.OrderFragmentPresenterImpl;
import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.entity.Person;
import cn.a17xiezuo.vmall.ui.view.IOrderView;
import cn.a17xiezuo.vmall.ui.widget.RVAdapter;


/**
 * @author wuyunan
 *         <p/>
 *         首页功能
 */
public class OrderFragment extends Fragment implements IOrderView {

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Unbinder unbinder;
    IOrderFragmentPresenter orderFragmentPresenter;

    public static OrderFragment newInstance() {
        OrderFragment fragment = new OrderFragment();
        return fragment;
    }

    public OrderFragment() {
        orderFragmentPresenter = new OrderFragmentPresenterImpl(getContext(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        initializeData();
        mAdapter = new RVAdapter(persons);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void showMessage(String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    private List<Person> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_service_pressed));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_order_pressed));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_mine_pressed));
    }




}
