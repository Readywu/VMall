package tech.niuchuang.mall.ui.widget.viewholder;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.niuchuang.mall.R;

/**
 * @author wuyunan
 */
public class HorizontalRecycleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.horizontal_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.tv_item_title)
    TextView textView;

    public HorizontalRecycleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    /**
     * @param text
     */
    public void setText(CharSequence text) {
        if (!TextUtils.isEmpty(text))
            this.textView.setText(text);
    }
}