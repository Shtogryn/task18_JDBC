package com.shtohryn.dao.implementation;

import com.shtohryn.dao.ReaderFormDao;
import com.shtohryn.model.ReaderFormModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderFormDaoImpl implements ReaderFormDao {
    private static final String FIND_ALL = "SELECT * FROM reader_form";
    private static final String DELETE = "DELETE FROM reader_form WHERE id_reader_form=?";
    private static final String CREATE = "INSERT reader_form (id_reader_form, reader_name, book_title) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE reader_form SET reader_name=?, book_title=? WHERE id_reader_form=?";
    private static final String FIND_BY_ID = "SELECT * FROM reader_form WHERE id_reader_form=?";

    @Override
    public List<ReaderFormModel> findByBookItem(String book) throws SQLException {
        List<ReaderFormModel> readerFormModel = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1, book);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    readerFormModel.add((ReaderFormModel) new Transformer<>(ReaderFormModel.class).fromResultSetToEntity(rs));
                }
            }
        }
        return readerFormModel;
    }

    @Override
    public List<ReaderFormModel> findAll() throws SQLException {
        List<ReaderFormModel> readerForm = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    readerForm.add((ReaderFormModel) new Transformer<>(ReaderFormModel.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return null;
    }

    @Override
    public ReaderFormModel findById(Integer integer) throws SQLException {
        ReaderFormModel readerFormModel = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    readerFormModel = (ReaderFormModel) new Transformer<>(ReaderFormModel.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public int create(ReaderFormModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getIdReaderForm());
            ps.setString(2, entity.getReaderName());
            ps.setString(3, entity.getBookTitle());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(ReaderFormModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getIdReaderForm());
            ps.setString(2, entity.getReaderName());
            ps.setString(3, entity.getBookTitle());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer integer) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, integer);
            return ps.executeUpdate();

        }
    }

}
