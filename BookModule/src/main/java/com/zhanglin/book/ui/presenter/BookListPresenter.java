package com.zhanglin.book.ui.presenter;

import android.support.annotation.NonNull;

import com.zhanglin.book.api.BookServiceApi;
import com.zhanglin.book.entity.BookResultEntity;
import com.zhanglin.book.ui.view.IBookView;
import com.zhanglin.commonlib.base.api.ThrowableResult;
import com.zhanglin.commonlib.base.presenter.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


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
        bookServiceApi.getBooks().subscribe(new Observer<BookResultEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

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

            @Override
            public void onError(Throwable e) {
                view.showError(((ThrowableResult) e).getErrorMsg());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
