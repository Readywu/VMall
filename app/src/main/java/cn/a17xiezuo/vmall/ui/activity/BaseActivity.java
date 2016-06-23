package cn.a17xiezuo.vmall.ui.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.a17xiezuo.vmall.MainActivity;
import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.xzlibrary.common.Constants;
import cn.a17xiezuo.xzlibrary.ui.view.swiperefresh.CSwipeRefreshLayout;
import cn.a17xiezuo.xzlibrary.utils.LogUtil;
import cn.a17xiezuo.xzlibrary.utils.ScreenManager;
/**
 * Created by wuyunan on 13-8-12.
 */
public abstract class BaseActivity extends FragmentActivity {

    protected static final String TAG = BaseActivity.class.getSimpleName();
    protected static final int REQUESTCODE_PICK_FILE = 1000;
    protected static final int REQUEST_CODE_GET_PHOTO = 1001;
    protected static final int REQUEST_CODE_TAKE_PHOTO = 1002;

    protected Uri mCapturedImageURI;
    protected Context mContext;
    protected String mLoginUserId;
    protected boolean isBackground = false;
    ScreenManager screenManager;
    // private UnReadPushMessageReceiver messageReceiver;
    int aType;
    int receiveType;
    Dialog dialog;
    private Intent mService;
    private CSwipeRefreshLayout mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mContext == null && savedInstanceState == null) {
            requestWindowFeature(Window.FEATURE_PROGRESS);
            // setProgressBarIndeterminate(true);
        }

        mContext = BaseActivity.this;
        // messageReceiver = new UnReadPushMessageReceiver();
//        mLoginUserId = SharedPreferencesUtil.getLoginUserId(mContext);
//        if (!(SharedPreferencesUtil.isAudoLoginIn(this) && !TextUtils
//                .isEmpty(SharedPreferencesUtil.getSessionId(this)))) {
//            goLoginActivity();
//        }
//        bindDeviceService();
        if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(false);
            getActionBar().setHomeButtonEnabled(true);
            getActionBar().setDisplayShowHomeEnabled(true);
            getActionBar().setDisplayShowTitleEnabled(false);// 去掉标题
            getActionBar().setDisplayShowCustomEnabled(true);
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
            getActionBar().setCustomView(getLayoutInflater()
                    .inflate(R.layout.view_common_actionbar_title, null), lp);
        }
        showProgressDialog(false);
        screenManager = ScreenManager.getScreenManager();
        screenManager.pushActivity(this);
        // setTranslucentStatus(true);
        // initSystemBar();
        // register();
    }

    /**
     * Set the activity content to an explicit view. This view is placed
     * directly into the activity's view hierarchy. It can itself be a complex
     * view hierarchy. When calling this method, the layout parameters of the
     * specified view are ignored. Both the width and the height of the view are
     * set by default to {@link ViewGroup.LayoutParams#MATCH_PARENT}. To use
     * your own layout parameters, invoke
     * {@link #setContentView(View, ViewGroup.LayoutParams)} instead.
     *
     * @param view The desired content to display.
     * @see #setContentView(int)
     * @see #setContentView(View, ViewGroup.LayoutParams)
     */
    @Override
    public void setContentView(View view) {
        // super.setContentView(view);
        init().addView(view);
    }

    /**
     * Set the activity content from a layout resource. The resource will be
     * inflated, adding all top-level views to the activity.
     *
     * @param layoutResID Resource ID to be inflated.
     * @see #setContentView(View)
     * @see #setContentView(View, ViewGroup.LayoutParams)
     */
    @Override
    public void setContentView(int layoutResID) {
        // super.setContentView(layoutResID);
        getLayoutInflater().inflate(layoutResID, init(), true);
    }

    /**
     * Set the activity content to an explicit view. This view is placed
     * directly into the activity's view hierarchy. It can itself be a complex
     * view hierarchy.
     *
     * @param view   The desired content to display.
     * @param params Layout parameters for the view.
     * @see #setContentView(View)
     * @see #setContentView(int)
     */
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        // super.setContentView(view, params);
        init().addView(view, params);
    }

    private ViewGroup init() {
        super.setContentView(R.layout.base_progress);
        mProgressBar = (CSwipeRefreshLayout) findViewById(R.id.activity_bar);
        mProgressBar.setColorSchemeResources(Constants.colorRes[0],
                Constants.colorRes[1], Constants.colorRes[2],
                Constants.colorRes[3]);
        return (ViewGroup) findViewById(R.id.activity_frame);
    }

    protected void initSystemBar() {
        // create our manager instance after the content view is set
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintColor(
                getResources().getColor(R.color.common_title_background));
    }

    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        android.view.Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    protected void setHomeAsBackImage() {
        getActionBar().setIcon(R.drawable.ic_actionbar_back);
    }

//    private void bindDeviceService() {
//        mServiceConnection = new SyncDataServiceConnection();
//
//        mService = new Intent(mContext, SyncDataService.class);
//
//        mContext.bindService(mService, mServiceConnection,
//                Context.BIND_AUTO_CREATE);
//    }

//    private void unbindDeviceService() {
//
//        mContext.unbindService(mServiceConnection);
//    }

    protected void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    protected void showKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, 0);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        JPushInterface.onPause(this);
//        StatService.onPause(this);
        isBackground = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        JPushInterface.onResume(this);
//        StatService.onResume(this);
        isBackground = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbindDeviceService();
        // unRegister();
    }

    @Override
    public void onBackPressed() {

        LogUtil.d(TAG, screenManager.getStackSize() + "");
        if (screenManager.getStackSize() == 1) {
            // if (screenManager.currentActivity().getClass()
            // .equals(WechatActivity.class)) {
            // Intent intent3 = new Intent(mContext,
            // WechatHistoryActivity.class);
            // startActivity(intent3);
            // } else {
            Intent intent = new Intent(mContext, MainActivity.class);
            startActivity(intent);
            // }
        }
        finish();
        overridePendingTransition(R.anim.animation_left_in,
                R.anim.animation_right_out);
    }

    public void exit() {

        // if (screenManager.getStackSize() >= 1) {
        // screenManager.popAllActivityExceptOne(MainActivity.class);
        // }
        screenManager.popAllActivity();

    }

    public void goLoginActivity() {
//        Intent intent = new Intent(mContext, BootandLoginActivity.class);
//        intent.putExtra(Constants.REQUEST_ANIMATOR, false);
//        startActivity(intent);
        finish();
    }

    public void showProgressDialog(final boolean show) {
        if (getActionBar() == null || mProgressBar == null)
            return;
        if (show) {
            mProgressBar.setRefreshing(true);
            mProgressBar.setVisibility(View.VISIBLE);
            // getProgressBar().setIndeterminate(true);
            // getProgressBar().setVisibility(View.VISIBLE);
            // // setProgressBarIndeterminateVisibility(true);
            // // setProgressBarVisibility(true);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mProgressBar.setRefreshing(false);
            // getProgressBar().setVisibility(View.GONE);
            // getProgressBar().setIndeterminate(false);
            // // setProgressBarIndeterminateVisibility(false);
            // // setProgressBarVisibility(false);
        }

    }

    protected void setCustomTitle(String title) {
        // getSupportActionBar().setTitle(title);
        if (getActionBar() != null) {
            if (getActionBar().getCustomView() != null) {
                TextView titleView = (TextView) getActionBar().getCustomView()
                        .findViewById(R.id.tv_action_title);
                if (titleView != null)
                    titleView.setText(title);
            }
        }
    }

    protected void setCustomTitle(String title,
                                  TextUtils.TruncateAt truncateAt) {
        // getSupportActionBar().setTitle(title);
        if (getActionBar() != null) {
            if (getActionBar().getCustomView() != null) {
                TextView titleView = (TextView) getActionBar().getCustomView()
                        .findViewById(R.id.tv_action_title);
                titleView.setEllipsize(truncateAt);
                if (titleView != null)
                    titleView.setText(title);
            }
        }
    }

    /**
     * 显示帮助图标以及设置点击事件
     *
     * @param
     */
    protected void showHelpLink(View.OnClickListener listener) {
        if (getActionBar() != null) {
            if (getActionBar().getCustomView() != null) {
                ImageView imageView = (ImageView) getActionBar().getCustomView()
                        .findViewById(R.id.actionbar_help_icon);
                imageView.setVisibility(View.VISIBLE);
                if (imageView != null && listener != null) {
                    imageView.setOnClickListener(listener);
                }

            }
        }
    }

    protected void setCustomTitleColor(int color) {
        if (getActionBar() != null) {
            if (getActionBar().getCustomView() != null) {
                TextView titleView = (TextView) getActionBar().getCustomView()
                        .findViewById(R.id.tv_action_title);
                if (titleView != null)
                    titleView.setTextColor(color);
            }
        }
    }

    protected String getCustomTitle() {
        String title = "";
        if (getActionBar() != null) {
            if (getActionBar().getCustomView() != null) {
                TextView titleView = (TextView) getActionBar().getCustomView()
                        .findViewById(R.id.tv_action_title);
                if (titleView != null)
                    title = titleView.getText().toString();
            }
        }
        return title;
    }

    /**
     * @param resid
     */
    protected void setCustomTitle(int resid) {
        if (getActionBar() != null) {
            // getSupportActionBar().setTitle(resid);
            if (getActionBar().getCustomView() != null) {
                TextView titleView = (TextView) getActionBar().getCustomView()
                        .findViewById(R.id.tv_action_title);
                if (titleView != null)
                    titleView.setText(resid);
            }
        }
    }

    /**
     * @param resid
     */
    protected void setCustomTitle(int resid, TextUtils.TruncateAt truncateAt) {
        if (getActionBar() != null) {
            // getSupportActionBar().setTitle(resid);
            if (getActionBar().getCustomView() != null) {
                TextView titleView = (TextView) getActionBar().getCustomView()
                        .findViewById(R.id.tv_action_title);
                titleView.setEllipsize(truncateAt);
                if (titleView != null)
                    titleView.setText(resid);
            }
        }
    }

    protected void setCustomSubTitle(String title) {
        if (getActionBar() != null) {
            // getSupportActionBar().setTitle(resid);
            if (getActionBar().getCustomView() != null) {
                TextView titleView = (TextView) getActionBar().getCustomView()
                        .findViewById(R.id.tv_action_subtitle);
                if (titleView != null) {
                    if (TextUtils.isEmpty(title))
                        titleView.setVisibility(View.GONE);
                    else
                        titleView.setVisibility(View.VISIBLE);
                    titleView.setText(title);
                }
            }
        }
    }

    /**
     * 是否是下拉类型的标题栏
     *
     * @param isDropDownType
     */
    protected void setDropDownTitleTypeView(boolean isDropDownType) {
        // this.isDropDownType = isDropDownType;
        if (getActionBar() != null && getActionBar().getCustomView() != null) {
            TextView textView = (TextView) getActionBar().getCustomView()
                    .findViewById(R.id.tv_action_title);
            if (isDropDownType) {
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null,
                        getResources().getDrawable(
                                R.drawable.btn_down_titlenav_normal),
                        null);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null,
                        null, null);
            }
        }

        if (!isDropDownType) {
            setCustomTitleOnClickListener(null);
        }
    }

    /**
     * 标题点击事件
     *
     * @param listener
     */
    protected void setCustomTitleOnClickListener(
            View.OnClickListener listener) {
        if (getActionBar() != null) {
            if (getActionBar().getCustomView() != null) {
                TextView titleButton = (TextView) getActionBar().getCustomView()
                        .findViewById(R.id.tv_action_title);
                if (titleButton != null)
                    titleButton.setOnClickListener(listener);
            }
        }
    }

    protected void showActionBar() {
        if (getActionBar() != null)
            getActionBar().show();

    }

    protected void hideActionBar() {
        if (getActionBar() != null)
            getActionBar().hide();
    }

    /**
     * @param message
     */
    protected void showMessage(String message) {
        if (isBackground)
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }


    public void openAlbum() {
        Intent intent = new Intent();
        // 打开Pictures画面Type为image/*
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, REQUEST_CODE_GET_PHOTO);
    }

    /**
     * 打开摄像头，拍照
     */
    public void doCapturePhotoFromCamera() {
        try {
            final Intent intent = getTakePickIntent();
            mCapturedImageURI = (Uri) intent
                    .getParcelableExtra(MediaStore.EXTRA_OUTPUT);
            startActivityForResult(intent, REQUEST_CODE_TAKE_PHOTO);
        } catch (ActivityNotFoundException e) {
            showMessage("打开照相机失败!");
        }
    }

    /**
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public Intent getTakePickIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String fileName;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        fileName = sdf.format(date);
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, fileName);
        Uri mCapturedImageURI = getContentResolver()
                .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);

        return intent;
    }


}
