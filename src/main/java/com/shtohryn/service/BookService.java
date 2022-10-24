package com.shtohryn.service;

import com.shtohryn.dao.implementation.BookDaoImpl;
import com.shtohryn.model.BookModel;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    public List<BookModel> findAll() throws SQLException {
        return new BookDaoImpl().findAll();
    }

    public BookModel findById(String s) throws SQLException {
        return new BookDaoImpl().findById(s);
    }

    public int create(BookModel bookModel) throws SQLException {
        return new BookDaoImpl().create(bookModel);
    }

    public int update(BookModel bookModel) throws SQLException {
        return new BookDaoImpl().update(bookModel);
    }

    public int delete(String s) throws SQLException {
        return new BookDaoImpl().delete(s);
    }
}
