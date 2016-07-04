package tech.niuchuang.mall.ui.widget;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Collection;

import tech.niuchuang.mall.R;
import tech.niuchuang.mall.entity.Topic;
import tech.niuchuang.xzlibrary.ui.widget.BaseRecyclerAdapter;
import tech.niuchuang.xzlibrary.ui.widget.RecyclerHolder;

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
