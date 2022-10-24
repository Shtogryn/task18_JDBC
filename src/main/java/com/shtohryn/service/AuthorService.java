package com.shtohryn.service;

import com.shtohryn.dao.implementation.AuthorDaoImpl;
import com.shtohryn.model.AuthorModel;

import java.sql.SQLException;
import java.util.List;

public class AuthorService {
    public List<AuthorModel> findAll() throws SQLException {
        return new AuthorDaoImpl().findAll();
    }

    public AuthorModel findById(String s) throws SQLException {
        return new AuthorDaoImpl().findById(s);
    }

    public int create(AuthorModel authorModel) throws SQLException {
        return new AuthorDaoImpl().create(authorModel);
    }

    public int update(AuthorModel authorModel) throws SQLException {
        return new AuthorDaoImpl().update(authorModel);
    }

    public int delete(String s) throws SQLException {
        return new AuthorDaoImpl().delete(s);
    }
}
