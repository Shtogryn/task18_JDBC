package com.shtohryn.dao.implementation;

import com.shtohryn.dao.BookDao;
import com.shtohryn.model.BookModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private static final String FIND_ALL = "SELECT * FROM book_entity";
    private static final String DELETE = "DELETE FROM book_entity WHERE book_title=?";
    private static final String CREATE = "INSERT book_entity (book_title, year, pages_number) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE book_entity SET year=?, pages_number=? WHERE book_title=?";
    private static final String FIND_BY_ID = "SELECT * FROM book_entity WHERE book_title=?";

    @Override
    public List<BookModel> findAll() throws SQLException {
        List<BookModel> bookModels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    bookModels.add((BookModel) new Transformer<>(BookModel.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return null;
    }

    @Override
    public BookModel findById(String s) throws SQLException {
        BookModel bookModel=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    bookModel = (BookModel) new Transformer<>(BookModel.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public int create(BookModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getBookTitle());
            ps.setInt(2, entity.getPages());
            ps.setInt(3, entity.getYear());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(BookModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getBookTitle());
            ps.setInt(2, entity.getPages());
            ps.setInt(3, entity.getYear());
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
