package com.zhanglin.book.entity;

import java.util.ArrayList;

public class BookResultEntity {
    public int count;
    public int start;
    public int total;
    public ArrayList<BookEntity> books;

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public ArrayList<BookEntity> getBooks() {
        return books;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setBooks(ArrayList<BookEntity> books) {
        this.books = books;
    }

}
