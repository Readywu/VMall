package tech.niuchuang.mall.ui.widget.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Collection;

import tech.niuchuang.mall.R;
import tech.niuchuang.mall.entity.Destination;
import tech.niuchuang.xzlibrary.ui.widget.BaseRecyclerAdapter;
import tech.niuchuang.xzlibrary.ui.widget.RecyclerHolder;

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
