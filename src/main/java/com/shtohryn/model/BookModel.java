package com.shtohryn.model;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.PrimaryKey;
import com.shtohryn.model.annotation.Table;

@Table(name = "book_entity")
public class BookModel {
    @PrimaryKey
    @Column(name = "book_title", length = 20)
    private String bookTitle;
    @Column(name = "year", length = 7)
    private int year;
    @Column(name = "pages_number", length = 10)
    private int pages;

    @Override
    public String toString() {
        return "BookModel{" +
                "bookTitle='" + bookTitle + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                '}';
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public BookModel() {
    }

    public BookModel(String bookTitle, int year, int pages) {
        this.bookTitle = bookTitle;
        this.year = year;
        this.pages = pages;
    }
}
