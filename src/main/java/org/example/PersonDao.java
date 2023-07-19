package org.example;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    final String DELETE_ALL_USERS = "DELETE FROM person";
    final String GET_USER = "SELECT * FROM person WHERE id = ?";
    final String DELETE_USER = "DELETE FROM person WHERE id = ?";
    final String INSERT_NEW_USER = "INSERT INTO person (lastname, name, year, email) VALUES(?,?,?,?)";
    private static Statement getStatement() throws SQLException {
        Connection connection = Config.getConnection();
        Statement statement = connection.createStatement();
        return statement;
    }
    @SneakyThrows
    public void cleanUserTable() {

        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_USERS); {
            int rez = preparedStatement.executeUpdate();
            if (rez != 0) {
                System.out.println("Нам удалось удалить " + rez + " пользователей");
            } else {
                System.out.println("Таблица и так была пуста");
            }
        }
    }
    @SneakyThrows
    public void createUsersTable() {
        Connection connection = Config.getConnection();
        Statement statement = connection.createStatement();{
            statement.execute("CREATE TABLE IF NOT EXISTS person " +
                    "(id serial primary key, name varchar(40), lastName varchar(40), year int, email varchar(40))");
        }
    }
    //id int primary key auto_increment
    //id serial primary key
    @SneakyThrows
    public void dropUserTable() {
        Statement statement = getStatement();
        {
            statement.execute("DROP TABLE IF EXISTS person");
            System.out.println("Нам удалось успешно удалить таблицу пользователей");
        }
    }
    public void insertUser(String name, String lastName, int year, String email) throws SQLException {

        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, year);
        preparedStatement.setString(4, email);
        preparedStatement.execute();
    }
    @SneakyThrows
    public void getUserById(int id) {

        Connection connection = Config.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_USER); {
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Сработал метод для получения полей таблицы с заданным номером id: " + id);
        }
    }
    @SneakyThrows
    public void deleteUser(int id) {

        Connection connection = Config.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_USER); {
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Удалили поле таблицы с номером id: " + id);
        }
    }
    @SneakyThrows
    public List<PersonDto> getAllUsers() {
        List<PersonDto> personDtoList = new ArrayList<>();
        Connection connection = Config.getConnection();
        Statement statement = connection.createStatement(); {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int year = resultSet.getInt("year");
                String email = resultSet.getString("email");
                PersonDto personDto = new PersonDto(id, name, lastName, year, email);
                personDtoList.add(personDto);
            }
            return personDtoList;
        }
    }
}
