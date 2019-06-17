package com.zhanglin.topic.ui.presenter;

import android.support.annotation.NonNull;

import com.zhanglin.commonlib.base.presenter.BasePresenter;
import com.zhanglin.topic.api.NewsServiceApi;
import com.zhanglin.topic.entity.NewsDetailEntity;
import com.zhanglin.topic.ui.view.INewsDetailView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhanglin on 2018/1/18.
 */

public class NewDetailPresenter extends BasePresenter<INewsDetailView> {

    private NewsServiceApi newsServiceApi;

    public NewDetailPresenter(@NonNull INewsDetailView view) {
        attachView(view);
    }

    @Override
    public void attachView(@NonNull INewsDetailView view) {
        super.attachView(view);
        newsServiceApi = new NewsServiceApi();
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void getNewDetail(String key) {
        view.showLoading();
        newsServiceApi.getNewDetail(key).subscribe(new Observer<NewsDetailEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(NewsDetailEntity newsDetailEntity) {
                view.hideLoading();
                if (newsDetailEntity != null) {
                    view.setNewData(newsDetailEntity);
                } else {
                    view.showEmpty();
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
