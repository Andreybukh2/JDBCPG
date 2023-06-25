package org.example;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
        userDao.cleanUserTable();
        userDao.dropUserTable();
        userDao.createUsersTable();
        userDao.insertUser ("Андрей", "Булдаков", 33);
        userDao.insertUser ("Сергей", "Гром", 50);
        userDao.insertUser ("Антон", "Харисов", 34);
        userDao.insertUser ("Евген", "Левин", 22);
        userDao.insertUser ("Катя", "Самсонова", 22);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Получили все поля до удаления " + userDao.getAllUsers());
        System.out.println("-------------------------------------------------------------");
        userDao.getUserById(1);
        System.out.println("-------------------------------------------------------------");
        userDao.deleteUser(2);
        System.out.println("Получили все поля после удаления " + userDao.getAllUsers());

    }

}
