package com.shtohryn.dao.implementation;

import com.shtohryn.dao.AuthorDao;
import com.shtohryn.model.AuthorModel;
import com.shtohryn.persistant.ConnectionManager;
import com.shtohryn.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    private static final String FIND_ALL = "SELECT * FROM author";
    private static final String DELETE = "DELETE FROM author WHERE author_name=?";
    private static final String CREATE = "INSERT author (author_name) VALUES (?)";
    private static final String UPDATE = "UPDATE author SET genre=? WHERE author_name=?";
    private static final String FIND_BY_ID = "SELECT * FROM author WHERE author_name=?";

    @Override
    public List<AuthorModel> findAll() throws SQLException {
        List<AuthorModel> author = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    author.add((AuthorModel) new Transformer<>(AuthorModel.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return null;
    }

    @Override
    public AuthorModel findById(String s) throws SQLException {
        AuthorModel authorModel = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    authorModel = (AuthorModel) new Transformer<>(AuthorModel.class).fromResultSetToEntity(resultSet);
                }
            }
        }
        return authorModel;
    }

    @Override
    public int create(AuthorModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setString(1, entity.getAuthorName());
            ps.setString(2, entity.getGenre());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(AuthorModel entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getAuthorName());
            ps.setString(2, entity.getGenre());
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
