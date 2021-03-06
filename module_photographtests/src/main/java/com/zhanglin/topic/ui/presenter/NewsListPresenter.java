package com.zhanglin.topic.ui.presenter;

import android.support.annotation.NonNull;

import com.zhanglin.commonlib.base.presenter.BasePresenter;
import com.zhanglin.topic.api.NewsServiceApi;
import com.zhanglin.topic.entity.NewsEntity;
import com.zhanglin.topic.ui.view.INewsListView;

import java.util.Date;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhanglin on 2018/1/16.
 */

public class NewsListPresenter extends BasePresenter<INewsListView> {
    private NewsServiceApi newsServiceApi;

    public NewsListPresenter(@NonNull INewsListView view) {
        attachView(view);
    }

    @Override
    public void attachView(@NonNull INewsListView view) {
        super.attachView(view);
        newsServiceApi = new NewsServiceApi();
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void getNewsList(boolean isRefresh) {
        if (!isRefresh) {
            view.showLoadingView();
        }
        newsServiceApi.getLatestNews().subscribe(new Observer<NewsEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onError(Throwable e) {
                view.showNetErrView(e.getMessage());
            }

            @Override
            public void onNext(NewsEntity newsEntity) {
                view.onRefreshCompleted();
                view.showRecycleContent();
                if (newsEntity != null && newsEntity.getStories().size() > 0) {
                    view.setNewsList(newsEntity.getStories());
                } else {
                    view.showEmptyView();
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getHistoryNews(int page) {
        String key = String.valueOf(Long.valueOf(getDateString(new Date())) - page);
        newsServiceApi.getHistoryNews(key).subscribe(new Observer<NewsEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NewsEntity newsEntity) {
                view.onLoadMoreComplete();
                if (newsEntity != null && newsEntity.getStories().size() > 0) {
                    view.onAddNews(newsEntity.getStories());
                } else {
                    view.noMoreData();
                    view.showToast("没有更多新闻了");
                }
            }

            @Override
            public void onError(Throwable e) {
                view.noMoreData();
                view.showToast("没有更多新闻了");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private String getDateString(Date date) {
        String year = (date.getYear() + 1900) + "";
        String mm = (date.getMonth() + 1) + "";
        if (Integer.valueOf(mm).intValue() < 10) {
            mm = "0" + mm;
        }
        String day = date.getDate() + "";
        if (Integer.valueOf(day).intValue() < 10) day = "0" + day;
        return year + mm + day;
    }
}
