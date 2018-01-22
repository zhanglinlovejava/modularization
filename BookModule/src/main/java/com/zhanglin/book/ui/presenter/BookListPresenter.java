package com.zhanglin.book.ui.presenter;

import android.support.annotation.NonNull;

import com.zhanglin.basiccomponent.base.presenter.BasePresenter;
import com.zhanglin.book.api.BookServiceApi;
import com.zhanglin.book.entity.BookResultEntity;
import com.zhanglin.book.ui.view.IBookView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by zhanglin on 2018/1/16.
 */

public class BookListPresenter extends BasePresenter<IBookView> {
    private BookServiceApi bookServiceApi;


    public BookListPresenter(@NonNull IBookView view) {
        attachView(view);
    }

    @Override
    public void attachView(@NonNull IBookView view) {
        super.attachView(view);
        bookServiceApi = new BookServiceApi();
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void getBooks() {
        view.showLoading();
        mSubscriptions.add(bookServiceApi.getBooks()
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<BookResultEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError();
                    }

                    @Override
                    public void onNext(BookResultEntity result) {
                        view.hideLoading();
                        if (result != null && result.books.size() > 0) {
                            view.setBookList(result.books);
                        } else {
                            view.showEmpty();
                        }
                    }
                }));
    }
}
