package com.zhanglin.topic.ui.view;

import com.zhanglin.commonlib.base.view.BaseRecyclerView;
import com.zhanglin.topic.entity.NewsStoryEntity;

import java.util.List;

/**
 * Created by zhanglin on 2018/1/16.
 */

public interface INewsListView extends BaseRecyclerView {
    void setNewsList(List<NewsStoryEntity> list);

    void onAddNews(List<NewsStoryEntity> list);
}
