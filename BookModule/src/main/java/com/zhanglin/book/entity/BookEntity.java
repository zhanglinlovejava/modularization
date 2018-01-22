package com.zhanglin.book.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Chenyc on 15/6/30.
 */
public class BookEntity implements Serializable, Parcelable {

    private String subtitle;
    private String[] author;
    private String pubdate;
    private String origin_title;
    private String image;
    private String catalog;
    private String alt;
    private String id;
    private String publisher;
    private String title;
    private String url;
    private String author_intro;
    private String summary;
    private String price;
    private String pages;
    private Images images;


    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public class Images implements Serializable {
        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "subtitle='" + subtitle + '\'' +
                ", author=" + Arrays.toString(author) +
                ", pubdate='" + pubdate + '\'' +
                ", origin_title='" + origin_title + '\'' +
                ", image='" + image + '\'' +
                ", catalog='" + catalog + '\'' +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", publisher='" + publisher + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", author_intro='" + author_intro + '\'' +
                ", summary='" + summary + '\'' +
                ", price='" + price + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.subtitle);
        dest.writeStringArray(this.author);
        dest.writeString(this.pubdate);
        dest.writeString(this.origin_title);
        dest.writeString(this.image);
        dest.writeString(this.catalog);
        dest.writeString(this.alt);
        dest.writeString(this.id);
        dest.writeString(this.publisher);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.author_intro);
        dest.writeString(this.summary);
        dest.writeString(this.price);
        dest.writeString(this.pages);
        dest.writeSerializable(this.images);
    }

    public BookEntity() {
    }

    protected BookEntity(Parcel in) {
        this.subtitle = in.readString();
        this.author = in.createStringArray();
        this.pubdate = in.readString();
        this.origin_title = in.readString();
        this.image = in.readString();
        this.catalog = in.readString();
        this.alt = in.readString();
        this.id = in.readString();
        this.publisher = in.readString();
        this.title = in.readString();
        this.url = in.readString();
        this.author_intro = in.readString();
        this.summary = in.readString();
        this.price = in.readString();
        this.pages = in.readString();
        this.images = (Images) in.readSerializable();
    }

    public static final Parcelable.Creator<BookEntity> CREATOR = new Parcelable.Creator<BookEntity>() {
        @Override
        public BookEntity createFromParcel(Parcel source) {
            return new BookEntity(source);
        }

        @Override
        public BookEntity[] newArray(int size) {
            return new BookEntity[size];
        }
    };
}
