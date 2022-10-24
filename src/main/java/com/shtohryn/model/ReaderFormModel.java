package com.shtohryn.model;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.Table;

@Table(name = "reader_form")
public class ReaderFormModel {
    @Column(name = "id_reader_form", length = 10)
    private Integer idReaderForm;
    @Column(name = "reader_name", length = 20)
    private String readerName;
    @Column(name = "book_title", length = 20)
    private String bookTitle;

    @Override
    public String toString() {
        return "ReaderFormModel{" +
                "idReaderForm=" + idReaderForm +
                ", readerName='" + readerName + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }

    public Integer getIdReaderForm() {
        return idReaderForm;
    }

    public void setIdReaderForm(Integer idReaderForm) {
        this.idReaderForm = idReaderForm;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public ReaderFormModel() {
    }

    public ReaderFormModel(Integer idReaderForm, String readerName, String bookTitle) {
        this.idReaderForm = idReaderForm;
        this.readerName = readerName;
        this.bookTitle = bookTitle;
    }
}