package com.shtohryn.model;

import com.shtohryn.model.annotation.Column;
import com.shtohryn.model.annotation.PrimaryKey;
import com.shtohryn.model.annotation.Table;

@Table(name = "reader")
public class ReaderModel {
    @PrimaryKey
    @Column(name = "reader_name", length = 25)
    private String readerName;
    @Column(name = "address_reader",length = 25)
    private String readerAddress;

    @Override
    public String toString() {
        return "ReaderModel{" +
                "readerName='" + readerName + '\'' +
                ", readerAddress='" + readerAddress + '\'' +
                '}';
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getReaderAddress() {
        return readerAddress;
    }

    public void setReaderAddress(String readerAddress) {
        this.readerAddress = readerAddress;
    }

    public ReaderModel() {
    }

    public ReaderModel(String readerName, String readerAddress) {
        this.readerName = readerName;
        this.readerAddress = readerAddress;
    }
}