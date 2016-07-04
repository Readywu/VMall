package tech.niuchuang.mall.ui.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import tech.niuchuang.mall.R;

public class CustomPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    String[] mResources = {
            "http://tupian.enterdesk.com/2015/gha/0800/1012/01.jpg",
            "http://tupian.enterdesk.com/2015/gha/0800/1012/02.jpg",
            "http://tupian.enterdesk.com/2015/gha/0800/1012/03.jpg",
            "http://tupian.enterdesk.com/2015/gha/0800/1012/04.jpg",
            "http://tupian.enterdesk.com/2015/gha/0800/1012/05.jpg",
            "http://tupian.enterdesk.com/2015/gha/0800/1012/06.jpg"
    };

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.viewpage_image, container, false);

        SimpleDraweeView imageView = (SimpleDraweeView) itemView.findViewById(R.id.imageView);
        imageView.setImageURI(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}