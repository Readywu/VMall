package cn.a17xiezuo.vmall.ui.activity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.entity.MenuCategory;
import cn.a17xiezuo.vmall.ui.fragment.ContactFragment;
import cn.a17xiezuo.vmall.ui.fragment.Home2Fragment;
import cn.a17xiezuo.vmall.ui.fragment.HomeFragment;
import cn.a17xiezuo.vmall.ui.fragment.MainActivity5Fragment;
import cn.a17xiezuo.vmall.ui.fragment.MainActivityFragment;
import cn.a17xiezuo.vmall.ui.widget.IconRadioButton;
import cn.a17xiezuo.xzlibrary.ui.widget.ContentViewPagerAdapter;
import cn.a17xiezuo.xzlibrary.ui.widget.NoScrollViewPager;
import cn.a17xiezuo.xzlibrary.utils.Log;
import cn.a17xiezuo.xzlibrary.utils.Utility;

public class Main2Activity extends BaseActivity implements View.OnClickListener {

    protected static final String TAG = MainActivity.class.getSimpleName();

    private static final String ROOT_NAME = MainActivityFragment.class
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
    LinearLayout ll_bottomMenu;

    @BindView(R.id.nav_message)
    IconRadioButton mNavMessageButton;

    @BindView(R.id.nav_applist)
    IconRadioButton mNavApplistButton;

    @BindView(R.id.nav_built)
    IconRadioButton navBuilt;

    @BindView(R.id.nav_conact)
    IconRadioButton navConact;

    @BindView(R.id.nav_personal)
    IconRadioButton navPersonal;

    private MenuCategory selected;
    private RadioButton bt_message;
    private RadioButton bt_applist;
    private RadioButton bt_contact;
    private RadioButton bt_buitl;
    private RadioButton bt_personal;
    private ArrayList<Fragment> fragments;
    private MainActivityFragment messageCenterFragment;
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

        bt_message = mNavMessageButton.getRadioButton();
        bt_applist = mNavApplistButton.getRadioButton();
        bt_contact = navConact.getRadioButton();
        bt_buitl = navBuilt.getRadioButton();
        bt_personal = navPersonal.getRadioButton();

        mNavMessageButton.setChecked(true);
        mNavApplistButton.setChecked(false);
        navConact.setChecked(false);
        navBuilt.setChecked(false);
        navPersonal.setChecked(false);


        bt_message.setId(R.id.nav_message_bt);
        bt_applist.setId(R.id.nav_applist_bt);
        bt_buitl.setId(R.id.nav_built_bt);
        bt_contact.setId(R.id.nav_conact_bt);
        bt_personal.setId(R.id.nav_personal_bt);

        bt_message.setOnClickListener(this); // modify by ylb 2015-09-22
        // 因为做了单击，所以取消系统单击事件
        bt_applist.setOnClickListener(this);
        bt_buitl.setOnClickListener(this);
        bt_contact.setOnClickListener(this);
        bt_personal.setOnClickListener(this);

//        DoubleClickUtility.registerDoubleClickListener(bt_message,
//                new OnDoubleClickListener() {
//                    @Override
//                    public void onSingleClick(View v) {
//                        if (contentViewpager.getCurrentItem() == 0) {
//                            return;
//                        } else {
//                            contentViewpager.setCurrentItem(0, false);
//                        }
//                        selected = MenuCategory.HOMEPAGE;
//                        setSelected(selected);
//                    }
//
//                    @Override
//                    public void onDoubleClick(View v) {
//                        if (selected != MenuCategory.HOMEPAGE) {
//                            contentViewpager.setCurrentItem(0, false);
//                            selected = MenuCategory.HOMEPAGE;
//                            setSelected(selected);
//                        } else {
//                            if (messageCenterFragment != null)
//                                messageCenterFragment.goToNextUnreadPosition();
//                        }
//                    }
//                });
    }

    /**
     * 设置底部菜单样式
     *
     * @param selected
     */
    public void setSelected(MenuCategory selected) {

        mNavMessageButton.setChecked(false);
        mNavApplistButton.setChecked(false);
        navConact.setChecked(false);
        navBuilt.setChecked(false);
        navPersonal.setChecked(false);
            if (selected == MenuCategory.HOMEPAGE) {
                mNavMessageButton.setChecked(true);

                setCustomTitle("消息中心");
            } else if (selected == MenuCategory.APP) {

                mNavApplistButton.setChecked(true);

                setCustomTitle("应用列表");
                setCustomSubTitle("");
            } else if (selected == MenuCategory.CONTACT) {

                navConact.setChecked(true);

                setCustomTitle("通讯录");
                setCustomSubTitle("");
            } else if (selected == MenuCategory.PERSON) {


                navPersonal.setChecked(true);

                setCustomTitle("我");
                setCustomSubTitle("");
            } else if (selected == MenuCategory.NEW) {
                navBuilt.setChecked(true);

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
        messageCenterFragment = MainActivityFragment.newInstance();

        fragments.add(MainActivityFragment.newInstance());
        fragments.add(ContactFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(Home2Fragment.newInstance());
        fragments.add(MainActivity5Fragment.newInstance());

        viewPagerAdapter = new ContentViewPagerAdapter(mFragmentManager,
                fragments);
        contentViewpager.setAdapter(viewPagerAdapter);
        contentViewpager.setCurrentItem(0, false);
        // 防止viewpager中的内容被清空，缓存三个页面。或者重写adapter中的destroyItem方法
        contentViewpager.setOffscreenPageLimit(4);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (isForeGround(mContext, ACTIVITY_NAME)) {
                    showGuide();
                }

            }
        }, 1000);
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
            case R.id.nav_message_bt:
                if (contentViewpager.getCurrentItem() == 0) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(0, false);
                }
                selected = MenuCategory.HOMEPAGE;
                break;
            case R.id.nav_applist_bt:
                if (contentViewpager.getCurrentItem() == 1) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(1, false);
                }
                selected = MenuCategory.APP;
                break;
            case R.id.nav_built_bt:
                if (contentViewpager.getCurrentItem() == 2) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(2, false);
                }
                selected = MenuCategory.NEW;
                break;
            case R.id.nav_conact_bt:
                if (contentViewpager.getCurrentItem() == 3) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(3, false);
                }
                selected = MenuCategory.CONTACT;
                break;
            case R.id.nav_personal_bt:
                if (contentViewpager.getCurrentItem() == 4) {
                    return;
                } else {
                    contentViewpager.setCurrentItem(4, false);
                }
                selected = MenuCategory.PERSON;
                break;
            default:
                break;

        }
        setSelected(selected);
    }

    @Override
    public void onBackPressed() {

        if (contentViewpager.getCurrentItem() != 0) {
            //getActionBar().show();
            setBottomMenuFrameLayoutVisible(true);
            selected = MenuCategory.HOMEPAGE;
            setSelected(selected);
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
        if (mNavMessageButton == null) {
            return;
        }
        if (count > 0) {
            mNavMessageButton.setRedpoint(true);
            mNavMessageButton.setCount(count);
        } else {
            mNavMessageButton.setRedpoint(false);
        }

    }

//    public void updateDraftNotice(int count, boolean hasNewVersion,
//            boolean hasActivity) {
//        if (navPersonal == null) {
//            return;
//        }
//        if (personalFragment == null) {
//            return;
//        }
//        if (count != 0 || hasNewVersion || hasActivity) {
//            navPersonal.setRedpoint(true);
//            personalFragment.setDraftPoint(count);
//        } else {
//            navPersonal.setRedpoint(false);
//            personalFragment.setDraftPoint(0);
//        }
//    }

//
//
//    public int initDraftsCount(ArrayList<ApiRequest> flowRequests) {
//        if (flowRequests == null) {
//            return 0;
//        } else {
//            if (flowRequests.size() == 0) {
//                return 0;
//            } else {
//                return flowRequests.size();
//            }
//        }
//
//    }


    /**
     * 菜单栏是否隐藏
     *
     * @param
     */
    public void setBottomMenuFrameLayoutVisible(boolean visible) {
        ll_bottomMenu.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setIsNeedControlDispatchTouchEvent(
            boolean isNeedControlDispatchTouchEvent) {
        this.isNeedControlDispatchTouchEvent = isNeedControlDispatchTouchEvent;
    }

    /**
     * 第一次安装时首页指导提示
     */
    private void showGuide() {
        ArrayList<String> resourcesIds = new ArrayList<String>();
        ArrayList<View> views = new ArrayList<View>();
        if (bt_message == null) {
            return;
        }
        views.add(bt_message);
        resourcesIds.add("bt_message");

        if (bt_applist == null) {
            return;
        }
        views.add(bt_applist);
        resourcesIds.add("bt_applist");

        if (bt_buitl == null) {
            return;
        }
        views.add(bt_buitl);
        resourcesIds.add("bt_built");
        if (bt_contact == null) {
            return;
        }
        views.add(bt_contact);
        resourcesIds.add("bt_contact");
        if (bt_personal == null) {
            return;
        }
        views.add(bt_personal);
        resourcesIds.add("bt_personal");

        //showGuideDialog(MainActivity.this, views, resourcesIds);
        return;
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
