package com.zhanglin.commonlib.base.presenter;

import android.support.annotation.NonNull;

import com.zhanglin.commonlib.base.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by zhanglin on 2018/1/16.
 */
public class BasePresenter<T extends BaseView> {
    protected T view;

    protected CompositeDisposable mSubscriptions;

    public void attachView(@NonNull T view) {
        this.view = view;
        mSubscriptions = new CompositeDisposable();
    }

    public void detachView() {
        if (mSubscriptions != null && !mSubscriptions.isDisposed()) {
            mSubscriptions.dispose();
        }
        view = null;
    }


}
