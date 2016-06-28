package cn.a17xiezuo.xzlibrary.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author 限制Viewpager不能执行滑动事件，
 */
public class NoScrollViewPager extends LazyViewPager {


    /**
     * @param context
     */
    public NoScrollViewPager(Context context) {
        super(context);

    }

    /**
     * @param context
     * @param attrs
     */
    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;//返回true拦截事件，使事件不再往下传递.事件要分发给后面的子控件
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;//不自己处理事件，终结事件
    }


}
