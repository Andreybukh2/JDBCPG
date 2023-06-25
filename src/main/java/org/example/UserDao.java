package org.example;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    @SneakyThrows
    public void cleanUserTable() {
        final String DELETE_ALL_USERS = "DELETE FROM peoples";
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
            statement.execute("CREATE TABLE IF NOT EXISTS peoples " +
                    "(id serial primary key, name varchar(40), lastName varchar(40), age int)");
        }
    }
    @SneakyThrows
    public void dropUserTable() {
        Connection connection = Config.getConnection();
        Statement statement = connection.createStatement();
        {
            statement.execute("DROP TABLE IF EXISTS peoples");
            System.out.println("Нам удалось успешно удалить таблицу пользователей");
        }
    }
    public void insertUser(String name, String lastName, int age) throws SQLException {
        final String INSERT_NEW_USER = "INSERT INTO peoples (name, lastname, age) VALUES(?,?,?)";
        Connection connection = Config.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, age);
        preparedStatement.execute();
    }
    @SneakyThrows
    public void getUserById(int id) {
        final String GET_USER = "SELECT * FROM peoples WHERE id = ?";
        Connection connection = Config.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_USER); {
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Сработал метод для получения полей таблицы с заданным номером id: " + id);
        }
    }
    @SneakyThrows
    public void deleteUser(int id) {
        final String DELETE_USER = "DELETE FROM peoples WHERE id = ?";
        Connection connection = Config.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_USER); {
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Удалили поле таблицы с номером id: " + id);
        }
    }
    @SneakyThrows
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        Connection connection = Config.getConnection();
        Statement statement = connection.createStatement(); {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM peoples");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                UserDto userDto = new UserDto(id, name, lastName, age);
                userDtoList.add(userDto);
            }
            return userDtoList;
        }
    }
}
