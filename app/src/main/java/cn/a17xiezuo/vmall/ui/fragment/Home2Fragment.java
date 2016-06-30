package cn.a17xiezuo.vmall.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.a17xiezuo.vmall.Presenter.IHomePresenter;
import cn.a17xiezuo.vmall.Presenter.impl.HomePresenterImpl;
import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.entity.Datum;
import cn.a17xiezuo.vmall.entity.Person;
import cn.a17xiezuo.vmall.ui.view.IHomeView;
import cn.a17xiezuo.vmall.ui.widget.Datum2Adapter;


/**
 * @author wuyunan
 *         <p/>
 *         首页功能
 */
public class Home2Fragment extends Fragment implements IHomeView {

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private GridLayoutManager mLayoutManager;

    private Unbinder unbinder;
    IHomePresenter homeFragmentPresenter;

    public static Home2Fragment newInstance() {
        Home2Fragment fragment = new Home2Fragment();
        return fragment;
    }

    public Home2Fragment() {
        homeFragmentPresenter = new HomePresenterImpl(getContext(), this);
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
        mLayoutManager = new GridLayoutManager(getContext(), 4);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                if (position == 0 || position == 1 || position == 2) {
                    return 4;
                }
                return 2;

            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mRecyclerView.setLayoutManager(mLayoutManager);

        homeFragmentPresenter.getHomeData();
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
    public void setPerson(Person person) {

    }


    @Override
    public void showMessage(String message) {

    }

    @Override
    public void refreshData(final Datum datum) {
        mAdapter = new Datum2Adapter(getContext(), datum);

        //mAdapter = new RVAdapter(persons);
        mRecyclerView.setAdapter(mAdapter);

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
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_applist_press));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_contact_press));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_personal_press));
    }


}
