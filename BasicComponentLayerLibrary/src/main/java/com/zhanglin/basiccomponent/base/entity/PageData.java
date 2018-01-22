package com.zhanglin.basiccomponent.base.entity;

import java.util.List;

/**
 * Created by zhanglin on 2017/7/25.
 */
public class PageData<T> {
    public int total;
    public int per_page;
    public int current_page;
    public int last_page;
    public String next_page_url;
    public String prev_page_url;
    public int from;
    public int to;
    public List<T> data;

    @Override
    public String toString() {
        return "data{" +
                "total=" + total +
                ", per_page=" + per_page +
                ", current_page=" + current_page +
                ", last_page=" + last_page +
                ", next_page_url=" + next_page_url +
                ", prev_page_url=" + prev_page_url +
                ", from=" + from +
                ", to=" + to +
                ", data=" + data +
                '}';
    }
}
