package com.zhanglin.book.ui.adapter;


import android.content.Context;

import com.zhanglin.basiccomponent.base.adapter.BaseAdapter;
import com.zhanglin.basiccomponent.base.adapter.BaseViewHolder;
import com.zhanglin.book.R;
import com.zhanglin.book.entity.BookEntity;

import java.util.ArrayList;

/**
 * Created by zhanglin on 2018/1/15.
 */

public class BookAdapter extends BaseAdapter<BookEntity> {
    public BookAdapter(Context context) {
        super(context, R.layout.book_item_book_list, new ArrayList<BookEntity>());
    }

    @Override
    protected void convert(BaseViewHolder helper, BookEntity item) {
        helper.setText(R.id.tvTitle, item.getTitle());
        String desc = "作者: " + (item.getAuthor().length > 0 ? item.getAuthor()[0] : "") + "\n副标题: " + item.getSubtitle()
                + "\n出版年: " + item.getPubdate() + "\n页数: " + item.getPages() + "\n定价:" + item.getPrice();
        helper.setText(R.id.tvDesc, desc);
        helper.setImageUrl(R.id.ivBook, item.getImage());

    }
}
