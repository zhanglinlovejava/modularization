package com.zhanglin.topic.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class NewsStoryEntity implements Parcelable {

    private static final String FIELD_TYPE = "type";
    private static final String FIELD_ID = "id";
    private static final String FIELD_GA_PREFIX = "ga_prefix";
    private static final String FIELD_IMAGES = "images";
    private static final String FIELD_TITLE = "title";

    private int type;
    private long id;
    private int gaPrefix;
    private List<String> images;
    private String title;

    public NewsStoryEntity(){

    }

    protected NewsStoryEntity(Parcel in) {
        type = in.readInt();
        id = in.readLong();
        gaPrefix = in.readInt();
        images = in.createStringArrayList();
        title = in.readString();
    }

    public static final Creator<NewsStoryEntity> CREATOR = new Creator<NewsStoryEntity>() {
        @Override
        public NewsStoryEntity createFromParcel(Parcel in) {
            return new NewsStoryEntity(in);
        }

        @Override
        public NewsStoryEntity[] newArray(int size) {
            return new NewsStoryEntity[size];
        }
    };

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setGaPrefix(int gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public int getGaPrefix() {
        return gaPrefix;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getImages() {
        return images;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof NewsStoryEntity){
            return ((NewsStoryEntity) obj).getId() == id;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return ((Long) id).hashCode();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeLong(id);
        dest.writeInt(gaPrefix);
        dest.writeStringList(images);
        dest.writeString(title);
    }
}