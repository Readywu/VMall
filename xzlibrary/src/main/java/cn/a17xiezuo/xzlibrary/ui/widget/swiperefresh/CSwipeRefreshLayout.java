/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.a17xiezuo.xzlibrary.ui.widget.swiperefresh;

import android.content.Context;
import android.util.AttributeSet;

/**
 * 共通的，可以改变继承 Created by yeh on 15-12-17.
 */
public class CSwipeRefreshLayout extends ImSwipeRefreshLayout
        implements ImSwipeRefreshLayout.OnRefreshListener {

    private OnRefreshListener mListener;

    /**
     * Simple constructor to use when creating a SwipeRefreshLayout from code.
     *
     * @param context
     */
    public CSwipeRefreshLayout(Context context) {
        super(context);
        init();
    }

    /**
     * Constructor that is called when inflating SwipeRefreshLayout from XML.
     *
     * @param context
     * @param attrs
     */
    public CSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        if (mListener != null)
            mListener.onRefresh();
    }

    public void setOnRefreshListener(
            OnRefreshListener listener) {
        mListener = listener;
    }

}
