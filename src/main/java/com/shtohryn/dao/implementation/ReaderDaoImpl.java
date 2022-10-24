package com.shtohryn.dao.implementation;

import com.shtohryn.dao.ReaderDao;
import com.shtohryn.model.ReaderModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderDaoImpl implements ReaderDao {
    private static final String FIND_ALL = "SELECT * FROM reader";
    private static final String DELETE = "DELETE FROM reader WHERE readerName=?";
    private static final String CREATE = "INSERT reader (readerName, reader_name, readerAddress) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE reader SET reader_name=?, readerAddress=? WHERE readerName=?";
    private static final String FIND_BY_ID = "SELECT * FROM reader WHERE readerName=?";

    @Override
    public List<ReaderModel> findAll() throws SQLException {
        List<ReaderModel> reader = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    reader.add((ReaderModel) new Transformer<>(ReaderModel.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return reader;
    }

    @Override
    public ReaderModel findById(String s) throws SQLException {
        ReaderModel reader = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    reader = (ReaderModel) new Transformer<>(ReaderModel.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return reader;
    }

    @Override
    public int create(ReaderModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getReaderName());
            ps.setString(2, entity.getReaderAddress());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(ReaderModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getReaderName());
            ps.setString(2, entity.getReaderAddress());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(String s) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setString(1, s);
            return ps.executeUpdate();

        }
    }
}
