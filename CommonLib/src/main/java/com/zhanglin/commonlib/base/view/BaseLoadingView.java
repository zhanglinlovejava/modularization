package com.zhanglin.commonlib.base.view;

/**
 * Created by zhanglin on 2018/1/16.
 */

public interface BaseLoadingView extends BaseView {

    void showLoading();

    void hideLoading();

    void showEmpty();

    void showError(String msg);
}
