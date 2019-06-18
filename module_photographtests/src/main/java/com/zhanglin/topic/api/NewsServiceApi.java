package com.zhanglin.topic.api;

import com.zhanglin.commonlib.base.api.ApiService;
import com.zhanglin.topic.entity.NewsDetailEntity;
import com.zhanglin.topic.entity.NewsEntity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by zhanglin on 2017/7/25.
 */

public class NewsServiceApi {
    private NewsService newsService;

    public NewsServiceApi() {
        newsService = ApiService.getInstance().provideRetrofit().create(NewsService.class);
    }

    public Observable<NewsEntity> getLatestNews() {
        return newsService.getLatestNews().subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<NewsEntity> getHistoryNews(String key) {
        return newsService.getHistoryNews(key).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<NewsDetailEntity> getNewDetail(String key) {
        return newsService.getNewsDetail(key).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
