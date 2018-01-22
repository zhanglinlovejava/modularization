package com.zhanglin.topic.api;

import com.zhanglin.basiccomponent.base.api.ApiService;
import com.zhanglin.topic.entity.NewsDetailEntity;
import com.zhanglin.topic.entity.NewsEntity;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by zhanglin on 2017/7/25.
 */

public class NewsServiceApi {
    private NewsService newsService;

    public NewsServiceApi() {
        newsService = ApiService.getInstance().provideRetrofit().create(NewsService.class);
    }

    public Observable<NewsEntity> getLatestNews() {
        return newsService.getLatestNews().subscribeOn(Schedulers.io());
    }

    public Observable<NewsEntity> getHistoryNews(String key) {
        return newsService.getHistoryNews(key).subscribeOn(Schedulers.io());
    }

    public Observable<NewsDetailEntity> getNewDetail(String key) {
        return newsService.getNewsDetail(key).subscribeOn(Schedulers.io());
    }

}
