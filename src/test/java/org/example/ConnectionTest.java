package org.example;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @SneakyThrows
    public void testConnection() {
        Connection connection = Config.getConnection();
        Assert.assertTrue(connection.isValid(1));
        Assert.assertFalse(connection.isClosed());
    }
}
