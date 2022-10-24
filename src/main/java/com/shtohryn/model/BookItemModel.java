package com.shtohryn.model;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.Table;

/**
 * FK_BookItem
 */
@Table(name = "book_item")
public class BookItemModel {
    @Column(name = "book_title", length = 20)
    private String bookTitle;
    @Column(name = "author_name", length = 20)
    private String authorName;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "BookItemModel{" +
                "bookTitle='" + bookTitle + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public BookItemModel() {
    }

    public BookItemModel(String bookTitle, String authorName) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
    }
}
