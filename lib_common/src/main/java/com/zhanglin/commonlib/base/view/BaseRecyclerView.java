package com.zhanglin.commonlib.base.view;

/**
 * Created by zhanglin on 2018/1/17.
 */

public interface BaseRecyclerView extends BaseView {
    /**
     * 显示没有数据的View
     */
    void showEmptyView();

    /**
     * 显示网络错误的View
     */
    void showNetErrView(String msg);

    /**
     * 显示加载数据的View
     */
    void showLoadingView();

    /**
     * 显示RecycleView里面内容，表示成功并且有数据
     */
    void showRecycleContent();

    /**
     * 刷新完成，隐藏加载进度对话框
     */
    void onRefreshCompleted();

    void onLoadMoreComplete();

    /**
     * 没有更多的数据,禁用掉上拉刷新
     */
    void noMoreData();
}
