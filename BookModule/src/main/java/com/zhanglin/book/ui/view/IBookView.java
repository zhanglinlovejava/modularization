package com.zhanglin.book.ui.view;

import com.zhanglin.commonlib.base.view.BaseLoadingView;
import com.zhanglin.book.entity.BookEntity;

import java.util.List;

/**
 * Created by zhanglin on 2018/1/16.
 */

public interface IBookView extends BaseLoadingView {
    void setBookList(List<BookEntity> list);

}
