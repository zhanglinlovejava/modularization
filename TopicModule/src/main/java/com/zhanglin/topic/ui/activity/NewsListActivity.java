package com.zhanglin.topic.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.zhanglin.commonlib.base.activity.BaseRecyclerActivity;
import com.zhanglin.commonlib.base.adapter.BaseAdapter;
import com.zhanglin.commonlib.router.RouterPath;
import com.zhanglin.mylibrary2.R;
import com.zhanglin.topic.entity.NewsStoryEntity;
import com.zhanglin.topic.ui.adapter.NewsListAdapter;
import com.zhanglin.topic.ui.presenter.NewsListPresenter;
import com.zhanglin.topic.ui.view.INewsListView;

import java.util.List;


/**
 * Created by zhanglin on 2018/1/5.
 */
@Route(path = RouterPath.PATH_TOPIC_NEWS_ACTIVITY)
public class NewsListActivity extends BaseRecyclerActivity implements INewsListView, OnRefreshLoadmoreListener, BaseAdapter.OnRecyclerViewItemClickListener {
    private NewsListAdapter adapter;
    private NewsListPresenter mPresenter;
    private int page = 1;

    @Override
    public void initUIAndData() {
        mPresenter = new NewsListPresenter(this);
        refreshLayout = findViewById(R.id.zhihu_refresh_layout);
        RecyclerView recyclerView = findViewById(R.id.zhihu_recyclerView);
        adapter = new NewsListAdapter(context);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        refreshLayout.setRefreshHeader(new BezierRadarHeader(context));
        refreshLayout.setOnRefreshLoadmoreListener(this);
        adapter.setOnRecyclerViewItemClickListener(this);
        getData(false);
    }


    @Override
    public void setNewsList(List<NewsStoryEntity> list) {
        adapter.setNewData(list);
    }

    @Override
    public void onAddNews(List<NewsStoryEntity> list) {
        adapter.addData(list);
    }

    @Override
    public int setLayoutId() {
        return R.layout.topic_act_news;
    }

    @Override
    public void onEmptyOrErrorRetry() {
        getData(false);
    }

    @Override
    public void onItemClick(View view, int position) {
        NewsStoryEntity newsStoryEntity = adapter.getItem(position);
        ARouter.getInstance().build(RouterPath.PATH_TOPIC_NEWS_DETAIL_ACTIVITY)
                .withString("title", newsStoryEntity.getTitle())
                .withString("id", String.valueOf(newsStoryEntity.getId()))
                .navigation();
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getHistoryNews(page);
        page++;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        page = 1;
        getData(true);
    }

    private void getData(boolean isRefresh) {

        mPresenter.getNewsList(isRefresh);
    }
}
