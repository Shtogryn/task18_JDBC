package com.shtohryn.dao;

import com.shtohryn.model.ReaderFormModel;

import java.sql.SQLException;
import java.util.List;

public interface ReaderFormDao extends GeneralDao<ReaderFormModel, Integer> {
    List<ReaderFormModel> findByBookItem(String book) throws SQLException;
}