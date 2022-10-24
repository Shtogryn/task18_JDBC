package com.shtohryn.dao.implementation;

import com.shtohryn.dao.BookItemDao;
import com.shtohryn.model.BookItemModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookItemDaoImpl implements BookItemDao {
    private static final String FIND_ALL = "SELECT * FROM book_item";
    private static final String DELETE = "DELETE FROM book_item WHERE book_title=?";
    private static final String CREATE = "INSERT book_item (book_title, author_name, book_title) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE book_item SET author_name=? WHERE book_title=?";
    private static final String FIND_BY_ID = "SELECT * FROM book_item WHERE book_title=?";

    @Override
    public List<BookItemModel> findAll() throws SQLException {
        List<BookItemModel> bookItemModels = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    bookItemModels.add((BookItemModel) new Transformer<>(BookItemModel.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return null;
    }

    @Override
    public BookItemModel findById(String s) throws SQLException {
        BookItemModel bookItemModel1=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    bookItemModel1 = (BookItemModel) new Transformer<>(BookItemModel.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return bookItemModel1;
    }

    @Override
    public int create(BookItemModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getBookTitle());
            ps.setString(2, entity.getAuthorName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(BookItemModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getBookTitle());
            ps.setString(2, entity.getAuthorName());
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
