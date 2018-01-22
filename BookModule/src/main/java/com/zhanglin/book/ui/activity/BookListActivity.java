package com.zhanglin.book.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhanglin.arouter.RouterPath;
import com.zhanglin.basiccomponent.base.activity.BaseLoadingActivity;
import com.zhanglin.basiccomponent.base.adapter.BaseAdapter;
import com.zhanglin.book.R;
import com.zhanglin.book.entity.BookEntity;
import com.zhanglin.book.ui.adapter.BookAdapter;
import com.zhanglin.book.ui.presenter.BookListPresenter;
import com.zhanglin.book.ui.view.IBookView;

import java.util.List;


/**
 * Created by zhanglin on 2018/1/5.
 */
@Route(path = RouterPath.PATH_BOOK_LIST_ACTIVITY)
public class BookListActivity extends BaseLoadingActivity implements IBookView,BaseAdapter.OnRecyclerViewItemClickListener {
    private BookAdapter adapter;
    private BookListPresenter mPresenter;

    @Override
    public void initUIAndData() {
        mPresenter = new BookListPresenter(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new BookAdapter(this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        mPresenter.getBooks();
        adapter.setOnRecyclerViewItemClickListener(this);

    }

    @Override
    public int setLayoutId() {
        return R.layout.book_act;
    }

    @Override
    public void onEmptyOrErrorRetry() {
        mPresenter.getBooks();
    }

    @Override
    public void setBookList(List<BookEntity> list) {
        adapter.setNewData(list);
    }

    @Override
    public void onItemClick(View view, int position) {
        ARouter.getInstance().build(RouterPath.PATH_BOOK_DETAIL_ACTIVITY)
                .withParcelable("book",adapter.getItem(position))
                .navigation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
