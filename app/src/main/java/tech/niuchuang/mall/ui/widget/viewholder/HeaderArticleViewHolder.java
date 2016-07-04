package tech.niuchuang.mall.ui.widget.viewholder;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.niuchuang.mall.R;

public class HeaderArticleViewHolder extends RecyclerView.ViewHolder {

    //轮播的最热新闻图片
    @BindView(R.id.vp_hottest)
    ViewPager vpHottest;
    //轮播图片下面的小圆点
    @BindView(R.id.ll_hottest_indicator)
    LinearLayout llHottestIndicator;

    //学院广播信息
    // @BindView(R.id.tv_college_broadcast)
    //TextView tvCollegeBroadcast;

    public HeaderArticleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public ViewPager getVpHottest() {
        return vpHottest;
    }

    public LinearLayout getLlHottestIndicator() {
        return llHottestIndicator;
    }
}