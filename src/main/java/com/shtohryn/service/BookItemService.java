package com.shtohryn.service;

import com.shtohryn.dao.implementation.BookItemDaoImpl;
import com.shtohryn.model.BookItemModel;
import com.shtohryn.model.BookModel;

import java.sql.SQLException;
import java.util.List;

public class BookItemService {
    public List<BookItemModel> findAll() throws SQLException {
        return new BookItemDaoImpl().findAll();
    }

    public BookItemModel findById(String s) throws SQLException {
        return new BookItemDaoImpl().findById(s);
    }

    public int create(BookItemModel authorModel) throws SQLException {
        return new BookItemDaoImpl().create(authorModel);
    }

    public int update(BookItemModel authorModel) throws SQLException {
        return new BookItemDaoImpl().update(authorModel);
    }

    public int delete(String s) throws SQLException {
        return new BookItemDaoImpl().delete(s);
    }
}
