package com.zhanglin.book.ui.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.zhanglin.book.R;
import com.zhanglin.book.entity.BookEntity;
import com.zhanglin.book.ui.fragment.DetailFragment;
import com.zhanglin.commonlib.base.activity.BaseLoadingActivity;
import com.zhanglin.commonlib.base.adapter.PagerAdapter;
import com.zhanglin.commonlib.router.RouterPath;


/**
 * Created by zhanglin on 2018/1/8.
 */
@Route(path = RouterPath.PATH_BOOK_DETAIL_ACTIVITY)
public class BookDetailActivity extends BaseLoadingActivity {

    private ViewPager mViewPager;
    @Autowired(name = "book")
    BookEntity mBook;

    @Override
    public void onEmptyOrErrorRetry() {

    }

    @Override
    public void initUIAndData() {
        ARouter.getInstance().inject(this);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        Toolbar toolbar = findViewById(R.id.toolbar);
        collapsingToolbar.setTitle(mBook.getTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ImageView ivImage = findViewById(R.id.ivImage);
        Glide.with(ivImage.getContext())
                .load(mBook.getImages().getLarge())
                .fitCenter()
                .into(ivImage);

        mViewPager = findViewById(R.id.viewpager);
        setupViewPager(mViewPager);
        tabLayout.addTab(tabLayout.newTab().setText("内容简介"));
        tabLayout.addTab(tabLayout.newTab().setText("作者简介"));
        tabLayout.addTab(tabLayout.newTab().setText("目录"));
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public int setLayoutId() {
        return R.layout.book_act_book_detail;
    }


    private void setupViewPager(ViewPager mViewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(DetailFragment.newInstance(mBook.getSummary()), "内容简介");
        adapter.addFragment(DetailFragment.newInstance(mBook.getAuthor_intro()), "作者简介");
        adapter.addFragment(DetailFragment.newInstance(mBook.getCatalog()), "目录");
        mViewPager.setAdapter(adapter);
    }


}
