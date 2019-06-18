package com.zhanglin.topic.ui.adapter;

import android.content.Context;

import com.zhanglin.commonlib.base.adapter.BaseAdapter;
import com.zhanglin.commonlib.base.adapter.BaseViewHolder;
import com.zhanglin.module_photographtests.R;
import com.zhanglin.topic.entity.NewsStoryEntity;

import java.util.ArrayList;

/**
 * Created by zhanglin on 2018/1/16.
 */

public class NewsListAdapter extends BaseAdapter<NewsStoryEntity> {

    public NewsListAdapter(Context context) {
        super(context, R.layout.topic_item_news, new ArrayList<NewsStoryEntity>());
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsStoryEntity item) {
        helper.setText(R.id.news_title, item.getTitle());
        helper.setImageUrl(R.id.news_image, item.getImages().get(0));

    }
}
