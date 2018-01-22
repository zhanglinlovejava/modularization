package com.zhanglin.basiccomponent.base.activity;

import android.view.View;
import android.widget.Toast;

import com.zhanglin.basiccomponent.base.view.BaseLoadingView;

import ezy.ui.layout.LoadingLayout;

/**
 * Created by zhanglin on 2018/1/12.
 */

public abstract class BaseLoadingActivity extends BaseActivity implements BaseLoadingView {
    protected LoadingLayout loadingLayout;

    public abstract void onEmptyOrErrorRetry();

    @Override
    public void showToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        if (loadingLayout == null) {
            loadingLayout = LoadingLayout.wrap(this);
            loadingLayout.setRetryListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onEmptyOrErrorRetry();
                }
            });
        }
        loadingLayout.showLoading();
    }

    @Override
    public void hideLoading() {
        if (loadingLayout != null)
            loadingLayout.showContent();
    }

    @Override
    public void showEmpty() {
        if (loadingLayout != null)
            loadingLayout.showEmpty();
    }

    @Override
    public void showError() {
        if (loadingLayout != null)
            loadingLayout.showError();
    }
}
