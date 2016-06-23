package cn.a17xiezuo.vmall.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;

import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.ui.activity.HTML5Activity;
import cn.a17xiezuo.xzlibrary.common.Constants;


public class MyURLSpan extends ClickableSpan {

    private Context mContext = null;
    private String mUrl = "";

    public MyURLSpan(Context context, String url) {
        this.mContext = context;
        this.mUrl = url;
    }

    @Override
    public void onClick(View widget) {
        Intent intent = new Intent();
        intent.setClass(mContext, HTML5Activity.class);
        intent.putExtra(Constants.EXTRA_URL, mUrl);
        mContext.startActivity(intent);
        ((Activity) mContext).overridePendingTransition(
                R.anim.animation_right_in, R.anim.animation_left_out);
        // AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        //
        // builder.setTitle("Sure to open link?")
        // .setMessage("Confirm?")
        // .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        //
        // @Override
        // public void onClick(DialogInterface dialog, int which) {
        //
        // // do some customization, like open your own WebView
        // // within your app.
        //
        // Intent intent = new Intent();
        // intent.setClass(mContext, WebViewActivity.class);
        // intent.putExtra(Constants.EXTRA_URL, mUrl);
        // mContext.startActivity(intent);
        // // mContext.overridePendingTransition(
        // // R.anim.animation_right_in,
        // // R.anim.animation_left_out);
        //
        // }
        //
        // })
        // .setNegativeButton("Cancel",
        // new DialogInterface.OnClickListener() {
        //
        // @Override
        // public void onClick(DialogInterface dialog,
        // int which) {
        //
        // }
        //
        // }).create().show();

    }

}
