package com.zhanglin.topic.api;


import com.zhanglin.basiccomponent.utils.ConverterName;
import com.zhanglin.topic.entity.NewsDetailEntity;
import com.zhanglin.topic.entity.NewsEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhanglin on 2017/7/25.
 */

public interface NewsService {
    @GET("http://news-at.zhihu.com/api/4/news/latest")
    Observable<NewsEntity> getLatestNews();

    @GET("http://news-at.zhihu.com/api/4/news/before/{path}")
    Observable<NewsEntity> getHistoryNews(@Path("path") String path);

    @GET("http://news-at.zhihu.com/api/4/news/{key}")
    Observable<NewsDetailEntity> getNewsDetail(@Path("key") String key);

    @GET("http://news.at.zhihu.com/css/news_qa.auto.css")
    @ConverterName("string")
    Observable<String> getCSS(@Query("v") String key);
}
