package com.zhanglin.commonlib.base.activity;


import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.zhanglin.commonlib.base.view.BaseRecyclerView;

/**
 * Created by zhanglin on 2018/1/17.
 */

public abstract class BaseRecyclerActivity extends BaseLoadingActivity implements BaseRecyclerView {
    protected RefreshLayout refreshLayout;

    @Override
    public void showEmptyView() {
        showEmpty();
    }

    @Override
    public void showNetErrView(String msg) {
        showError(msg);
    }

    @Override
    public void showLoadingView() {
        showLoading();
    }

    @Override
    public void showRecycleContent() {
        loadingLayout.showContent();
    }

    @Override
    public void onLoadMoreComplete() {
        if (refreshLayout!=null){
            refreshLayout.finishLoadmore();
        }
    }

    @Override
    public void onRefreshCompleted() {
        if (refreshLayout != null) {
            refreshLayout.finishRefresh();
            refreshLayout.setEnableLoadmore(true);
        }
    }

    @Override
    public void noMoreData() {
        if (refreshLayout != null) {
            refreshLayout.finishLoadmore();
            refreshLayout.setEnableLoadmore(false);
        }
    }
}
