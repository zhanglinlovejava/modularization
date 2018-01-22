package com.zhanglin.book.api;


import com.zhanglin.book.entity.BookResultEntity;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by zhanglin on 2017/7/25.
 */

public interface BookService {
    @GET("https://api.douban.com/v2/book/search")
    Observable<BookResultEntity> getBooks(@QueryMap Map<String, String> options);
}
