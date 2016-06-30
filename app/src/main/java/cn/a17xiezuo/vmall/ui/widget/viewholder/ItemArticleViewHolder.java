package cn.a17xiezuo.vmall.ui.widget.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.a17xiezuo.vmall.R;

public class ItemArticleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rcv_article_photo)
    SimpleDraweeView rcvArticlePhoto;
    @BindView(R.id.rcv_article_title)
    TextView rcvArticleTitle;
    @BindView(R.id.rcv_article_date)
    TextView rcvArticleDate;
    @BindView(R.id.rcv_article_source)
    TextView rcvArticleSource;
    @BindView(R.id.rcv_article_readtimes)
    TextView rcvArticleReadtimes;
    @BindView(R.id.rcv_article_preview)
    TextView rcvArticlePreview;

    public ItemArticleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}