package com.xhuabu.huangquan.lib_ui.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.Keep;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.xhuabu.huangquan.lib_ui.view.InnerViewPager;
import com.xhuabu.huangquan.lib_ui.R;
import com.xhuabu.huangquan.lib_ui.R2;
import com.xhuabu.huangquan.lib_ui.util.DpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *  默认持有下面的 @NonNull 对应的id值的view
 */
@Keep
@UiThread
public class BannerHolder {
    public static final String INTENT_KEY_LINK = "banner_link";
    public static final String INTENT_KEY_TITLE = "banner_title";




    //该值是影响实例化viewpage的视图View的数目，而且只能左右滑动10次
    private static int MAX = Integer.MAX_VALUE;
    private static final String TAG = BannerHolder.class.getSimpleName();

    private String[] mPictures;
    private String[] mLinks;
    private int mCurrentPos;
    private String[] mTitles;
    private Handler mainHandler;


    //view
    private View mContainerView;
    @NonNull
    @BindView(R2.id.innerviewpage)
    InnerViewPager mViewPager;
    @NonNull
    @BindView(R2.id.point_container)
    LinearLayout mContainerIndicator;
    @NonNull
    @BindView(R2.id.btn_close_ad)
    ImageButton mCloseButton;

    public View getHolderView() {
        return mContainerView;
    }

    //listener
    private OnItemClickListener mItemClickListener;
    public void setLinkDataWithListener(String[] links, String[] titles, OnItemClickListener listener) {
        mLinks = links;
        mTitles = titles;
        mItemClickListener = listener;
    }

    private Class mJumpActivity;
    public void setLinkDataWithActivity(String[] links, String[] titles, Class activityClazz) {
        mLinks = links;
        mTitles = titles;
        mJumpActivity = activityClazz;
    }

    //view id
    private  int R_ID_DOT_SELECTED = R.drawable.ic_dot_selected;
    private  int R_ID_DOT_NORMAL = R.drawable.ic_dot;

    /**
     * 切换默认的小圆点
     * @param dotNormal
     * @param dotSelected
     */
    public void setDotId(@DrawableRes int dotNormal, @DrawableRes int dotSelected) {
        R_ID_DOT_NORMAL = dotNormal;
        R_ID_DOT_SELECTED = dotSelected;
        if (mContainerIndicator != null) {
            initDotContainer();
        }
    }


    public BannerHolder(Context context) {

        init(context, 0);
    }

    public BannerHolder(Context context, @LayoutRes int layoutId) {

        init(context, layoutId);
    }

    private void init(Context context, int layoutId) {
        if (this.mainHandler == null) {
            this.mainHandler = new Handler();
        }

        mContainerView = (layoutId == 0 ? LayoutInflater.from(context).inflate(R.layout.item_home_banner, null) : LayoutInflater.from(context).inflate(layoutId, null));

        ButterKnife.bind(this, mContainerView);

        initEvent();
    }


    private void initEvent() {
        // 自动轮播
        final AutoScrollTask autoScrollTask = new AutoScrollTask();
        autoScrollTask.start();
        // 按下去的时候停止轮播
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        autoScrollTask.stop();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        autoScrollTask.start();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        //关闭视图
        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContainerView.setVisibility(View.GONE);
            }
        });
    }


    /**
     * only call once or will be throw exception
     *
     * @param data
     */
    public void refreshHolderView(String[] data) {
        mPictures = data;
        mViewPager.setAdapter(new PicturesPagerAdapter());

        clearChildViews();
        // 添加indicator
        initDotContainer();

        // 自带监听器，滑动时候切换indicaotor
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                position = position % mPictures.length;
                // 1.还原所有效果
                for (int i = 0; i < mPictures.length; i++) {
                    ImageView ivIndicator = (ImageView) mContainerIndicator.getChildAt(i);
                    ivIndicator.setImageResource(R_ID_DOT_NORMAL);
                }
                // 2.选中对应效果
                ImageView ivIndicator = (ImageView) mContainerIndicator.getChildAt(position);
                ivIndicator.setImageResource(R_ID_DOT_SELECTED);
                // 改变当前的位置
                mCurrentPos = position;

            }
        });

        int index = MAX / 2;
        int diff = MAX / 2 % mPictures.length;// 0 7
        index = index - diff;
        mViewPager.setCurrentItem(index);
    }

    private void initDotContainer() {
        mContainerIndicator.removeAllViews();
        for (int i = 0; i < mPictures.length; i++) {
            ImageView imageView = new ImageView(mContainerIndicator.getContext());
            LinearLayout.LayoutParams parmas = new LinearLayout.LayoutParams(DpUtils.viewDp2Px(mContainerIndicator.getContext(), 6), DpUtils.viewDp2Px(mContainerIndicator.getContext(), 6));
            imageView.setImageResource(R_ID_DOT_NORMAL);
            // 选中第一个
            if (i == 0) {
                imageView.setImageResource(R_ID_DOT_SELECTED);
            } else {
                parmas.leftMargin = DpUtils.viewDp2Px(mContainerIndicator.getContext(), 6);
            }
            mContainerIndicator.addView(imageView, parmas);
        }
    }

    private void clearChildViews() {
        mViewPager.removeAllViews();
        mContainerIndicator.removeAllViews();
    }

    /**
     * 清楚mViewPage 的监听器
     */
    public void clearPageListener() {
        if (mViewPager != null) {
            mViewPager.clearOnPageChangeListeners();
        }
    }

    class AutoScrollTask implements Runnable {
        /**
         * 开始
         */
        public void start() {
            BannerHolder.this.getMainThreadHandler().removeCallbacks(this);
            BannerHolder.this.getMainThreadHandler().postDelayed(this, 2000);
        }

        /**
         * 停止
         */
        public void stop() {
            BannerHolder.this.getMainThreadHandler().removeCallbacks(this);
        }

        @Override
        public void run() {
            int currentItem = mViewPager.getCurrentItem();
            currentItem++;
            mViewPager.setCurrentItem(currentItem);
            // 递归
            start();
        }
    }

    private Handler getMainThreadHandler() {
        return mainHandler;
    }

    class PicturesPagerAdapter extends PagerAdapter {
        private static final String TAG = "PagerAdapter";

        @Override
        public int getCount() {
            if (mPictures != null) {

                return MAX;
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(final ViewGroup container, int position) {
            position = position % mPictures.length;
            ImageView itemView = new ImageView(container.getContext());
            itemView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //添加错误的背景图片
            itemView.setBackgroundResource(R.drawable.chain_default_icon);
            //加载图片
            if (!TextUtils.isEmpty(mPictures[position])) {
                Glide.with(container.getContext()).load(mPictures[position]).into(itemView);
            }
            //添加点击监听操作
            if (mLinks != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mLinks == null || mTitles == null) {
                            return;
                        }

                        String title = mCurrentPos < mTitles.length ? mTitles[mCurrentPos] : "";
                        String link = mCurrentPos < mLinks.length ? mLinks[mCurrentPos] : "";

                        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(link)) {
                            return ;
                        }

                        boolean isConsumed = false;
                        //优先处理外部的监听器事件
                        if (mItemClickListener != null) {
                            isConsumed = mItemClickListener.OnItemClick(title, link);
                        }

                        if (isConsumed) {
                            return;
                        }

                        //再处理本地自定义事件
                        if (BannerHolder.this.mJumpActivity != null) {
                            Intent intent = new Intent(container.getContext(), BannerHolder.this.mJumpActivity);
                            intent.putExtra(INTENT_KEY_LINK, link);
                            intent.putExtra(INTENT_KEY_TITLE, title);
                            container.getContext().startActivity(intent);
                        }


                    }
                });
            }
            //加入容器
            container.addView(itemView);//有可能报异常"The specified child already has a parent. You must call removeView() on the child's parent first"
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    public interface OnItemClickListener {
        boolean OnItemClick(String title, String link);
    }
}