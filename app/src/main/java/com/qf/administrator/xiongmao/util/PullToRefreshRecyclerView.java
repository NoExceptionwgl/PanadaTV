package com.qf.administrator.xiongmao.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.qf.administrator.xiongmao.R;

/**
 * Created by Rock on 2016/8/29.
 */
public class PullToRefreshRecyclerView extends PullToRefreshBase<RecyclerView> {
    public PullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshRecyclerView(Context context) {
        super(context);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshRecyclerView(Context context, Mode mode, AnimationStyle animStyle) {
        super(context, mode, animStyle);
    }

    /**
     * 获取刷新滚动的方向
     *
     * @return
     */
    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    /**
     * @param context Context to create view with
     * @param attrs   AttributeSet from wrapped class. Means that anything you
     *                include in the XML layout declaration will be routed to the
     *                created View
     * @return
     */
    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
        RecyclerView recyclerView = new RecyclerView(context, attrs);
        //设置一个id
        recyclerView.setId(R.id.recycler);
        return recyclerView;
    }

    /**
     * 是否准备好  下拉刷新 (从左向右拉的刷新) 从开始的地方刷新
     *
     * @return true 准备好了 false 不进入刷新状态  没准备好
     */
    @Override
    protected boolean isReadyForPullStart() {
        //获取刷新的view
        RecyclerView recyclerView = getRefreshableView();
        if (recyclerView.getChildAt(0) == null) {
            return false;
        } else {
            //获取RecyclerView中的第一项
            View childAt = recyclerView.getChildAt(0);
            //获取RecyclerView的顶部内边距
            int paddingTop = recyclerView.getPaddingTop();
            //获取child的顶部外边距
            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            int topMargin = layoutParams.topMargin;
            //获取第一个item距离顶部的高度
            int top = childAt.getTop();

            return top == paddingTop + topMargin;
        }
    }

    /**
     * 是否准备好 上拉加载(从右向左的刷新) 从结束的地方刷新
     *
     * @return true 准备好了 false 不进入刷新状态  没准备好
     */
    @Override
    protected boolean isReadyForPullEnd() {
        //获取刷新的View
        RecyclerView refreshableView = getRefreshableView();
        //获取RecyclerView的最后一个item
        int childCount = refreshableView.getChildCount();

        View childAt = refreshableView.getChildAt(childCount - 1);
        //获取RecyclerView的高度
        int height = refreshableView.getHeight();
        //获取RecyclerView的底部内边距
        int paddingBottom = refreshableView.getPaddingBottom();
        //获取最后一个item的底部外边距
        if (childAt != null) {

            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            int bottomMargin = layoutParams.bottomMargin;
            //获取child 底部距离RecyclerView顶部的距离
            int bottom = childAt.getBottom();
            //添加一个判断条件 获取一下RecyclerView的Adapter中的item条数
            int itemCount = refreshableView.getAdapter().getItemCount();
            //计算最后一个view在适配器中的位置
            int childAdapterPosition = refreshableView.getChildAdapterPosition(childAt);

            return height == bottom + bottomMargin + paddingBottom && itemCount == childAdapterPosition + 1;
        }else {
            return false;
        }

    }

}
