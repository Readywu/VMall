package cn.a17xiezuo.vmall.ui.activity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.entity.MenuCategory;
import cn.a17xiezuo.vmall.ui.fragment.DiscoverFragment;
import cn.a17xiezuo.vmall.ui.fragment.HomeFragment;
import cn.a17xiezuo.vmall.ui.fragment.OrderFragment;
import cn.a17xiezuo.vmall.ui.fragment.PersonCenterFragment;
import cn.a17xiezuo.vmall.ui.fragment.ServiceFragment;
import cn.a17xiezuo.vmall.ui.widget.IconRadioButton;
import cn.a17xiezuo.xzlibrary.ui.widget.ContentViewPagerAdapter;
import cn.a17xiezuo.xzlibrary.ui.widget.NoScrollViewPager;
import cn.a17xiezuo.xzlibrary.utils.Log;
import cn.a17xiezuo.xzlibrary.utils.Utility;

public class RootActivity extends BaseActivity implements View.OnClickListener {

    protected static final String TAG = MainActivity.class.getSimpleName();

    private static final String ROOT_NAME = ServiceFragment.class
            .getSimpleName();
    private static final String ACTIVITY_NAME = MainActivity.class.getName();

    boolean isNeedGoHome = false;
    private FragmentManager mFragmentManager;
    private String message;
    private String mFragmentName;

    // private int type = Constants.TankExpandType.ALL.ordinal();


    private boolean isNeedControlDispatchTouchEvent = false; // 是否使用内部的dispatchTouchEvent重写，默认不使用内部的


    @BindView(R.id.content_viewpager)
    NoScrollViewPager contentViewpager;

    // 底部栏
    @BindView(R.id.ll_bottom_menu)
    LinearLayout mBottomMenuLinearLayout;

    @BindView(R.id.nav_home)
    IconRadioButton mNavHomeButton;

    @BindView(R.id.nav_category)
    IconRadioButton mNavCategoryButton;

    @BindView(R.id.nav_order)
    IconRadioButton mNavOrderButton;

    @BindView(R.id.nav_service)
    IconRadioButton mNavServiceButton;

    @BindView(R.id.nav_personal)
    IconRadioButton mNavPersonalButton;

    private MenuCategory menuCategory;
    private ArrayList<Fragment> fragments;
    private ServiceFragment messageCenterFragment;
    private ContentViewPagerAdapter viewPagerAdapter;

    private boolean hasActivity;


    public void setHasActivity(boolean hasActivity) {
        this.hasActivity = hasActivity;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);
        mFragmentName = ROOT_NAME;
        mFragmentManager = getSupportFragmentManager();

        initUI();

        initDatas();


    }


    /**
     * 初始化控件
     */
    private void initUI() {
        // setCustomTitle("消息中心");
        showActionBar();

        mNavHomeButton.setChecked(true);
        mNavCategoryButton.setChecked(false);
        mNavServiceButton.setChecked(false);
        mNavOrderButton.setChecked(false);
        mNavPersonalButton.setChecked(false);


        mNavHomeButton.setButtonId(R.id.nav_home_bt);
        mNavCategoryButton.setButtonId(R.id.nav_category_bt);
        mNavServiceButton.setButtonId(R.id.nav_service_bt);
        mNavOrderButton.setButtonId(R.id.nav_order_bt);
        mNavPersonalButton.setButtonId(R.id.nav_personal_bt);

        mNavHomeButton.setButtonOnClickListener(this); // modify by ylb 2015-09-22
        mNavCategoryButton.setButtonOnClickListener(this);
        mNavServiceButton.setButtonOnClickListener(this);
        mNavOrderButton.setButtonOnClickListener(this);
        mNavPersonalButton.setButtonOnClickListener(this);

    }

    /**
     * 设置底部菜单样式
     *
     * @param selected
     */
    public void setSelected(MenuCategory selected) {

        mNavHomeButton.setChecked(false);
        mNavCategoryButton.setChecked(false);
        mNavServiceButton.setChecked(false);
        mNavOrderButton.setChecked(false);
        mNavPersonalButton.setChecked(false);
        if (selected == MenuCategory.HOME) {
            mNavHomeButton.setChecked(true);

            setCustomTitle("消息中心");
        } else if (selected == MenuCategory.CATEGORY) {

            mNavCategoryButton.setChecked(true);

            setCustomTitle("应用列表");
            setCustomSubTitle("");
        } else if (selected == MenuCategory.SERVICE) {

            mNavServiceButton.setChecked(true);

            setCustomTitle("通讯录");
            setCustomSubTitle("");
        } else if (selected == MenuCategory.PERSON) {


            mNavPersonalButton.setChecked(true);

            setCustomTitle("我");
            setCustomSubTitle("");
        } else if (selected == MenuCategory.ORDER) {
            mNavOrderButton.setChecked(true);

            setCustomTitle("我");
            setCustomSubTitle("");
        }


    }

    /**
     * 初始化数据viewpager的数据
     */
    public void initDatas() {
        if (fragments != null) {
            fragments = null;
        }
        fragments = new ArrayList<Fragment>();
        messageCenterFragment = ServiceFragment.newInstance();

        fragments.add(HomeFragment.newInstance());
        fragments.add(DiscoverFragment.newInstance());
        fragments.add(ServiceFragment.newInstance());
        fragments.add(OrderFragment.newInstance());
        fragments.add(PersonCenterFragment.newInstance());

        viewPagerAdapter = new ContentViewPagerAdapter(mFragmentManager,
                fragments);

        contentViewpager.setAdapter(viewPagerAdapter);
        contentViewpager.setCurrentItem(0, false);

        // 防止viewpager中的内容被清空，缓存三个页面。或者重写adapter中的destroyItem方法
        contentViewpager.setOffscreenPageLimit(4);
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                if (isForeGround(mContext, ACTIVITY_NAME)) {
//                   // showGuide();
//                }
//
//            }
//        }, 1000);
    }


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();


        // 通知栏清除
        // NotificationHelper.clearNotification(mContext);

        // 是否需要回到消息页面
        if (isNeedGoHome) {
            // popAllFragmentStack();
            contentViewpager.setCurrentItem(0, false);
            isNeedGoHome = false;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        Log.d(TAG, contentViewpager.getCurrentItem() + " " + viewId);
        switch (viewId) {
            case R.id.nav_home_bt:
                if (contentViewpager.getCurrentItem() == 0) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(0, false);
                }
                menuCategory = MenuCategory.HOME;
                break;
            case R.id.nav_category_bt:
                if (contentViewpager.getCurrentItem() == 1) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(1, false);
                }
                menuCategory = MenuCategory.CATEGORY;
                break;
            case R.id.nav_service_bt:
                if (contentViewpager.getCurrentItem() == 2) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(2, false);
                }
                menuCategory = MenuCategory.SERVICE;
                break;
            case R.id.nav_order_bt:
                if (contentViewpager.getCurrentItem() == 3) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(3, false);
                }
                menuCategory = MenuCategory.ORDER;
                break;
            case R.id.nav_personal_bt:
                if (contentViewpager.getCurrentItem() == 4) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(4, false);
                }
                menuCategory = MenuCategory.PERSON;
                break;
            default:
                break;

        }
        setSelected(menuCategory);
    }

    @Override
    public void onBackPressed() {

        if (contentViewpager.getCurrentItem() != 0) {
            //getActionBar().show();
            setBottomMenuFrameLayoutVisible(true);
            menuCategory = MenuCategory.HOME;
            setSelected(menuCategory);
            contentViewpager.setCurrentItem(0, false);
        } else {
            finish();

        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//        case R.id.action_search:
//            goToCreateWechat();
//            break;
//        default:
//            break;
//        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!isNeedControlDispatchTouchEvent) {
            try {
                if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                    View v = getCurrentFocus();
                    if (Utility.isShouldHideInput(v, ev)) {
                        InputMethodManager inputMethodManager = (InputMethodManager) mContext
                                .getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager
                                .hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
                return super.dispatchTouchEvent(ev);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 底部菜单消息数量
     *
     * @param count
     */
    public void updateMsgCenterCount(int count) {
        if (mNavHomeButton == null) {
            return;
        }
        if (count > 0) {
            mNavHomeButton.setRedpoint(true);
            mNavHomeButton.setCount(count);
        } else {
            mNavHomeButton.setRedpoint(false);
        }

    }


    /**
     * 菜单栏是否隐藏
     *
     * @param
     */
    public void setBottomMenuFrameLayoutVisible(boolean visible) {
        mBottomMenuLinearLayout.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setIsNeedControlDispatchTouchEvent(
            boolean isNeedControlDispatchTouchEvent) {
        this.isNeedControlDispatchTouchEvent = isNeedControlDispatchTouchEvent;
    }


    // 判断当前的activity是否是在前台显示
    private boolean isForeGround(Context context, String className) {

        if (context == null || TextUtils.isEmpty(className)) {
            return false;
        }
        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> rtis = am.getRunningTasks(1);
        if (rtis != null && rtis.size() > 0) {
            ComponentName cpn = rtis.get(0).topActivity;
            if (className.equals(cpn.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
