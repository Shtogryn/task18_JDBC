package com.shtohryn.service;

import com.shtohryn.dao.implementation.ReaderFormDaoImpl;
import com.shtohryn.model.ReaderFormModel;

import java.sql.SQLException;
import java.util.List;

public class ReaderFormService {
    public List<ReaderFormModel> findByBookItem(String book) throws SQLException {
        return new ReaderFormDaoImpl().findByBookItem(book);
    }

    public List<ReaderFormModel> findAll() throws SQLException {
        return new ReaderFormDaoImpl().findAll();
    }

    public ReaderFormModel findById(Integer integer) throws SQLException {
        return new ReaderFormDaoImpl().findById(integer);
    }

    public int create(ReaderFormModel authorModel) throws SQLException {
        return new ReaderFormDaoImpl().create(authorModel);
    }

    public int update(ReaderFormModel authorModel) throws SQLException {
        return new ReaderFormDaoImpl().update(authorModel);
    }

    public int delete(Integer integer) throws SQLException {
        return new ReaderFormDaoImpl().delete(integer);
    }
}
