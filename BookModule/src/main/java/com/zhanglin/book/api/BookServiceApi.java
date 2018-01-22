package com.zhanglin.book.api;

import com.zhanglin.basiccomponent.base.api.ApiService;
import com.zhanglin.book.entity.BookResultEntity;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by zhanglin on 2017/7/25.
 */

public class BookServiceApi {
    BookService bookService;

    public BookServiceApi() {
        bookService = ApiService.getInstance().provideRetrofit().create(BookService.class);
    }

    public Observable<BookResultEntity> getBooks() {
        Map<String, String> params = new HashMap<>();
        params.put("q", "战争");
        params.put("start", "0");
        params.put("end", "50");
        return bookService.getBooks(params).subscribeOn(Schedulers.io());
    }
}
