package cn.a17xiezuo.vmall.ui.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.entity.Event;

public class EventAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;


    List<Event> eventList;

    public EventAdapter(Context context, List<Event> list) {
        mContext = context;
        this.eventList = list;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.viewpage_image, container, false);

        SimpleDraweeView imageView = (SimpleDraweeView) itemView.findViewById(R.id.imageView);
        Event event = eventList.get(position);
        imageView.setImageURI(event.getImage());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}