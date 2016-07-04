package tech.niuchuang.mall.ui.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import tech.niuchuang.mall.R;
import tech.niuchuang.mall.entity.Datum;
import tech.niuchuang.mall.entity.Destination;
import tech.niuchuang.mall.entity.Event;
import tech.niuchuang.mall.ui.widget.viewholder.DestinationViewHolder;
import tech.niuchuang.mall.ui.widget.viewholder.HeaderArticleViewHolder;
import tech.niuchuang.mall.ui.widget.viewholder.HeaderViewHolder;
import tech.niuchuang.mall.ui.widget.viewholder.HorizontalRecycleViewHolder;
import tech.niuchuang.mall.ui.widget.viewholder.ItemArticleViewHolder;

/**
 */
public class Datum2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_EVENT = 1;
    private static final int TYPE_TOPIC = 2;
    private static final int TYPE_destination = 3;
    private static final int TYPE_ITEM = 4;
    //头部固定为 张图片
    private static final int NUM_IMAGE = 4;

    //Handler 用到的参数值
    private static final int UPTATE_VIEWPAGER = 0;
    private static final String TAG = Datum2Adapter.class.getSimpleName();

    //新闻列表
    private Datum datum;

    //设置当前 第几个图片 被选中
    private int currentIndex = 0;

    //context
    private Context context;

    private LayoutInflater mLayoutInflater;


    public Datum2Adapter(Context context, Datum datum) {
        this.context = context;

        //头部viewpager图片固定是7张，剩下的是列表的数据
        this.datum = datum;
        mLayoutInflater = LayoutInflater.from(context);


        // 初始化图片资源


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //理论上应该把最可能返回的 TYPE 放在前面
        View view = null;
        Log.d(TAG, "onCreateViewHolder " + viewType);

        if (viewType == TYPE_ITEM) {
            view = mLayoutInflater.inflate(
                    R.layout.viewholder_article_item, parent, false);
            return new ItemArticleViewHolder(view);
        }

        if (viewType == TYPE_EVENT) {
            view = mLayoutInflater.inflate(
                    R.layout.viewholder_article_header, parent, false);
            return new HeaderArticleViewHolder(view);
        }

        //头部返回 ViewPager 实现的轮播图片
        if (viewType == TYPE_TOPIC) {
            view = mLayoutInflater.inflate(
                    R.layout.item_recyclerview, parent, false);
            return new HorizontalRecycleViewHolder(view);
        }

        if (viewType == TYPE_destination) {
            view = mLayoutInflater.inflate(
                    R.layout.item_recyclerview, parent, false);
            return new HorizontalRecycleViewHolder(view);
        }

        return null;
//        //可以抛出异常，没有对应的View类型
//        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.d(TAG, "" + position);
        //转型
        if (holder instanceof HorizontalRecycleViewHolder) {
            if (position == 1) {
                HorizontalRecycleViewHolder newHolder = (HorizontalRecycleViewHolder) holder;
                //注意RecyclerView第0项是 ViewPager 占据了0 1 2 3图片
                //那么下面的列表展示是 RecyclerView 的第1项，从第4项开始
                newHolder.getRecyclerView().setAdapter(new TopicAdapter(newHolder.getRecyclerView(),
                        datum.getTopic(), R.layout.viewholder_image_item));
                newHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(context,
                        LinearLayoutManager.HORIZONTAL, false));
                newHolder.setText("话题");

            } else {
                HorizontalRecycleViewHolder newHolder = (HorizontalRecycleViewHolder) holder;
                //注意RecyclerView第0项是 ViewPager 占据了0 1 2 3图片
                //那么下面的列表展示是 RecyclerView 的第1项，从第4项开始
                newHolder.getRecyclerView().setAdapter(new DestinationAdapter(newHolder.getRecyclerView(),
                        datum.getDestination(), R.layout.viewholder_image_item));
                newHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(context,
                        LinearLayoutManager.HORIZONTAL, false));
                newHolder.setText("全球购物");
            }

        } else if (holder instanceof DestinationViewHolder) {
            DestinationViewHolder newHolder = (DestinationViewHolder) holder;
            //注意RecyclerView第0项是 ViewPager 占据了0 1 2 3图片
            //那么下面的列表展示是 RecyclerView 的第1项，从第4项开始
            Destination article = datum.getDestination().get(position - datum.getTopic().size() - 3);
            newHolder.getRcvArticlePhoto().setImageURI(Uri.parse(article.getImage()));
            newHolder.getRcvArticleTitle().setText(article.getName());
            newHolder.getRcvArticleDate().setText(article.getTotalFollows());
        } else if (holder instanceof ItemArticleViewHolder) {

        } else if (holder instanceof HeaderViewHolder) {

        } else if (holder instanceof HeaderArticleViewHolder) {
            HeaderArticleViewHolder newHolder = (HeaderArticleViewHolder) holder;

            List<Event> headers = datum.getEvents();

            setUpViewPager(newHolder.getVpHottest(), newHolder.getLlHottestIndicator(), headers);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    private void setUpViewPager(final ViewPager vp, LinearLayout llBottom, final List<Event> eventList) {
        EventAdapter eventAdapter = new EventAdapter(context, eventList);
        //??这儿有些疑惑，Adapter 里面嵌套设置 Adapter 是否优雅？
        vp.setAdapter(eventAdapter);

        final Handler mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPTATE_VIEWPAGER:
                        if (msg.arg1 != 0) {
                            vp.setCurrentItem(msg.arg1);
                        } else {
                            //false 当从末页调到首页是，不显示翻页动画效果，
                            vp.setCurrentItem(msg.arg1, false);
                        }
                        break;
                }
            }
        };

        //下面是设置动画切换的样式
        vp.setPageTransformer(true, new RotateUpTransformer());

        //创建底部指示位置的导航栏
        final ImageView[] mCircleImages = new ImageView[6];
        llBottom.removeAllViews();
        for (int i = 0; i < 6; i++) {
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            params.setMargins(5, 0, 5, 0);
            imageView.setLayoutParams(params);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.ic_loading_s);
            } else {
                imageView.setBackgroundResource(R.drawable.ic_order_pressed);
            }

            mCircleImages[i] = imageView;
            //把指示作用的原点图片加入底部的视图中
            llBottom.addView(mCircleImages[i]);

        }

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //图片左右滑动时候，将当前页的圆点图片设为选中状态
            @Override
            public void onPageSelected(int position) {
                // 一定几个图片，几个圆点，但注意是从0开始的
                int total = 6;
                for (int j = 0; j < total; j++) {
                    if (j == position) {
                        mCircleImages[j].setBackgroundResource(R.drawable.ic_loading_s);
                    } else {
                        mCircleImages[j].setBackgroundResource(R.drawable.ic_order_pressed);
                    }
                }

                //设置全局变量，currentIndex为选中图标的 index
                currentIndex = position;
            }

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                //实现切换到末尾后返回到第一张
                switch (state) {
                    // 手势滑动
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        break;

                    // 界面切换中
                    case ViewPager.SCROLL_STATE_SETTLING:
                        break;

                    case ViewPager.SCROLL_STATE_IDLE:// 滑动结束，即切换完毕或者加载完毕
                        // 当前为最后一张，此时从右向左滑，则切换到第一张
                        if (vp.getCurrentItem() == vp.getAdapter()
                                .getCount() - 1) {
                            vp.setCurrentItem(0, false);
                        }
                        // 当前为第一张，此时从左向右滑，则切换到最后一张
                        else if (vp.getCurrentItem() == 0) {
                            vp.setCurrentItem(vp.getAdapter()
                                    .getCount() - 1, false);
                        }
                        break;

                    default:
                        break;
                }
            }
        });


        //设置自动轮播图片，5s后执行，周期是5s

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = UPTATE_VIEWPAGER;
                if (currentIndex == datum.getEvents().size() - 1) {
                    currentIndex = -1;
                }
                message.arg1 = currentIndex + 1;
                mHandler.sendMessage(message);
            }
        }, 6000, 6000);
    }

    @Override
    public int getItemCount() {
        //因为多了一个头部，所以是+1,但是头部 ViewPager 占了7个
        //所以实际是少了6个
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_EVENT;
        } else if (position == 1) {
            return TYPE_TOPIC;
        } else if (position == 2) {
            return TYPE_destination;
        }
        return TYPE_ITEM;
    }


}