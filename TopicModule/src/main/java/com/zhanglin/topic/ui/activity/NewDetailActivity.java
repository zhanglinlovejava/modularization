package com.zhanglin.topic.ui.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.zhanglin.arouter.RouterPath;
import com.zhanglin.commonlib.base.activity.BaseLoadingActivity;
import com.zhanglin.commonlib.utils.DisplayUtil;
import com.zhanglin.mylibrary2.R;
import com.zhanglin.topic.entity.NewsDetailEntity;
import com.zhanglin.topic.ui.presenter.NewDetailPresenter;
import com.zhanglin.topic.ui.view.INewsDetailView;

/**
 * Created by zhanglin on 2018/1/18.
 */
@Route(path = RouterPath.PATH_TOPIC_NEWS_DETAIL_ACTIVITY)
public class NewDetailActivity extends BaseLoadingActivity implements INewsDetailView {
    private WebView webView;
    private ImageView titleImageView;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private NewDetailPresenter mPresenter;
    private String id;

    @RequiresApi(api = Build.VERSION_CODES.ECLAIR_MR1)
    @Override
    public void initUIAndData() {
        mPresenter = new NewDetailPresenter(this);
        String title = getIntent().getStringExtra("title");
        id = getIntent().getStringExtra("id");
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        titleImageView = findViewById(R.id.ivImage);
        webView = findViewById(R.id.webView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        collapsingToolbarLayout.setTitle(DisplayUtil.decodeUrlParam(title));
        mPresenter.getNewDetail(id);
    }

    @Override
    public void onEmptyOrErrorRetry() {
        mPresenter.getNewDetail(id);
    }

    @Override
    public void setNewData(NewsDetailEntity value) {
        collapsingToolbarLayout.setTitle(value.getTitle());
        Glide.with(context)
                .load(value.getImage())
                .asBitmap()
                .into(titleImageView);
        if (value.getCss() != null && value.getCss().size() > 0) {
            String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/news.css\" type=\"text/css\">";
            String html = "<html><head>" + css + "</head><body>" + value.getBody() + "</body></html>";
            html = html.replace("<div class=\"img-place-holder\">", "");
            webView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null);
        } else {
            webView.loadData(value.getBody(), "text/html", "utf-8");
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.topic_act_news_detail;
    }
}
