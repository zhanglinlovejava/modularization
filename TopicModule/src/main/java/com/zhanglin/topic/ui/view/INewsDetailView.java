package com.zhanglin.topic.ui.view;

import com.zhanglin.basiccomponent.base.view.BaseLoadingView;
import com.zhanglin.topic.entity.NewsDetailEntity;

/**
 * Created by zhanglin on 2018/1/16.
 */

public interface INewsDetailView extends BaseLoadingView {
    void setNewData(NewsDetailEntity newData);

}
