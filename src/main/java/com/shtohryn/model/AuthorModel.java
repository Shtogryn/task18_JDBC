package com.shtohryn.model;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.PrimaryKey;
import com.shtohryn.model.annotation.Table;

@Table(name = "author")
public class AuthorModel {
    @PrimaryKey
    @Column(name = "author_name", length = 20)
    private String authorName;
    @Column(name = "genre", length = 15)
    private String genre;

    @Override
    public String toString() {
        return "AuthorModel{" +
                "authorName='" + authorName + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public AuthorModel(String authorName, String genre) {
        this.authorName = authorName;
        this.genre = genre;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public AuthorModel() {
    }

    public AuthorModel(String authorName) {
        this.authorName = authorName;
    }
}
