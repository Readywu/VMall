package cn.a17xiezuo.vmall.ui.widget;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Collection;

import cn.a17xiezuo.vmall.R;
import cn.a17xiezuo.vmall.entity.Topic;
import cn.a17xiezuo.xzlibrary.ui.widget.BaseRecyclerAdapter;
import cn.a17xiezuo.xzlibrary.ui.widget.RecyclerHolder;

/**
 * Created by wuyunan on 16/6/30.
 */
public class TopicAdapter extends BaseRecyclerAdapter<Topic> {
    public TopicAdapter(RecyclerView v, Collection<Topic> datas, int itemLayoutId) {
        super(v, datas, itemLayoutId);
    }

    @Override
    public void convert(RecyclerHolder holder, Topic item, int position, boolean isScrolling) {
        ((SimpleDraweeView) holder.getView(R.id.rcv_article_photo)).setImageURI(Uri.parse(item.getImage()));
        holder.setText(R.id.rcv_article_title, item.getName());
    }
}
