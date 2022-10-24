package com.shtohryn.service;

import com.shtohryn.dao.implementation.ReaderDaoImpl;
import com.shtohryn.model.ReaderFormModel;
import com.shtohryn.model.ReaderModel;

import java.sql.SQLException;
import java.util.List;

public class ReaderService {
    public List<ReaderModel> findAll() throws SQLException {
        return new ReaderDaoImpl().findAll();
    }

    public ReaderModel findById(String s) throws SQLException {
        return new ReaderDaoImpl().findById(s);
    }

    public int create(ReaderModel readerModel) throws SQLException {
        return new ReaderDaoImpl().create(readerModel);
    }

    public int update(ReaderModel readerModel) throws SQLException {
        return new ReaderDaoImpl().update(readerModel);
    }

    public int delete(String s) throws SQLException {
        return new ReaderDaoImpl().delete(s);
    }
}
