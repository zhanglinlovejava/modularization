package com.zhanglin.basiccomponent.base.view;

/**
 * Created by zhanglin on 2018/1/16.
 */

public interface BaseLoadingView extends BaseView {

    void showLoading();

    void hideLoading();

    void showEmpty();

    void showError();
}
