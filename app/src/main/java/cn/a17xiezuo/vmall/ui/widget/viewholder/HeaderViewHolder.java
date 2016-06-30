package cn.a17xiezuo.vmall.ui.widget.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.a17xiezuo.vmall.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.rcv_article_photo)
    SimpleDraweeView rcvArticlePhoto;
    @BindView(R.id.rcv_article_title)
    TextView rcvArticleTitle;

    public HeaderViewHolder(View itemView) {
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

}