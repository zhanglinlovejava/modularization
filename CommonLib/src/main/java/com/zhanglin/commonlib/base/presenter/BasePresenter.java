package com.zhanglin.commonlib.base.presenter;

import android.support.annotation.NonNull;

import com.zhanglin.commonlib.base.view.BaseView;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by zhanglin on 2018/1/16.
 */
public class BasePresenter<T extends BaseView> {
    protected T view;

    protected CompositeSubscription mSubscriptions;

    public void attachView(@NonNull T view) {
        this.view = view;
        mSubscriptions = new CompositeSubscription();
    }

    public void detachView() {
        if (mSubscriptions != null && !mSubscriptions.isUnsubscribed()) {
            mSubscriptions.unsubscribe();
        }
        view = null;
    }


}
