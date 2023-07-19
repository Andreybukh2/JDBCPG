package org.example;

import lombok.SneakyThrows;

import java.sql.*;

public class BookDao {

    private static Statement getStatement() throws SQLException {
        Connection connection = Config.getConnection();
        Statement statement = connection.createStatement();
        return statement;
    }
    @SneakyThrows
    public void createBooksTable() {
        Connection connection = Config.getConnection();
        Statement statement = connection.createStatement();{
            statement.execute("CREATE TABLE IF NOT EXISTS books " +
                    "(id serial primary key, titleOfBook varchar(40), author varchar(30), yearOfPublication int)");
        }
    }
    //id int primary key auto_increment
    //id serial primary key
    public void insertNewBook (String titleOfBook, String author, int yearOfPublication) throws SQLException {
        final String INSERT_NEW_BOOK = "INSERT INTO books (titleOfBook, author, yearOfPublication) VALUES(?,?,?)";
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BOOK);
        preparedStatement.setString(1, titleOfBook);
        preparedStatement.setString(2, author);
        preparedStatement.setInt(3, yearOfPublication);
        preparedStatement.execute();
    }
}

