package org.example;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class Config {
    private static final String user = "postgres";
    private static final String password = "2510";
    private static final String dataBase = "postgres";
    private static final String url = "jdbc:postgresql://localhost:5432/" + dataBase;

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(url, user, password);
    }
}
