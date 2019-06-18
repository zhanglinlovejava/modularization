package com.zhanglin.topic.entity;

import java.util.List;


public class NewsEntity {
    private List<NewsStoryEntity> stories;
    private String date;
    public NewsEntity(){

    }

    public void setStories(List<NewsStoryEntity> stories) {
        this.stories = stories;
    }

    public List<NewsStoryEntity> getStories() {
        return stories;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }


}