package cn.a17xiezuo.vmall.ui.widget;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Collection;

import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.entity.Destination;
import cn.a17xiezuo.xzlibrary.ui.widget.BaseRecyclerAdapter;
import cn.a17xiezuo.xzlibrary.ui.widget.RecyclerHolder;

/**
 * Created by wuyunan on 16/6/30.
 */
public class DestinationAdapter extends BaseRecyclerAdapter<Destination> {
    public DestinationAdapter(RecyclerView v, Collection<Destination> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

    @Override
    public void convert(RecyclerHolder holder, Destination item, int position, boolean isScrolling) {
        ((SimpleDraweeView) holder.getView(R.id.rcv_article_photo)).setImageURI(Uri.parse(item.getImage()));
        holder.setText(R.id.rcv_article_title, item.getName());
        holder.getView(R.id.rcv_article_title).setVisibility(View.GONE);
    }
}
