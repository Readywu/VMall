package cn.a17xiezuo.vmall.ui.widget.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.a17xiezuo.vmall.R;

public class TopicViewHolder extends RecyclerView.ViewHolder {

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

    public TopicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public SimpleDraweeView getRcvArticlePhoto() {
        return rcvArticlePhoto;
    }

    public void setRcvArticlePhoto(SimpleDraweeView rcvArticlePhoto) {
        this.rcvArticlePhoto = rcvArticlePhoto;
    }

    public TextView getRcvArticleTitle() {
        return rcvArticleTitle;
    }

    public void setRcvArticleTitle(TextView rcvArticleTitle) {
        this.rcvArticleTitle = rcvArticleTitle;
    }

    public TextView getRcvArticleDate() {
        return rcvArticleDate;
    }

    public void setRcvArticleDate(TextView rcvArticleDate) {
        this.rcvArticleDate = rcvArticleDate;
    }

    public TextView getRcvArticleSource() {
        return rcvArticleSource;
    }

    public void setRcvArticleSource(TextView rcvArticleSource) {
        this.rcvArticleSource = rcvArticleSource;
    }

    public TextView getRcvArticleReadtimes() {
        return rcvArticleReadtimes;
    }

    public void setRcvArticleReadtimes(TextView rcvArticleReadtimes) {
        this.rcvArticleReadtimes = rcvArticleReadtimes;
    }

    public TextView getRcvArticlePreview() {
        return rcvArticlePreview;
    }

    public void setRcvArticlePreview(TextView rcvArticlePreview) {
        this.rcvArticlePreview = rcvArticlePreview;
    }
}