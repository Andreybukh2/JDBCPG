package org.example;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        PersonDao personDao = new PersonDao();
        //userDao.cleanUserTable();
        personDao.dropUserTable();
        personDao.createUsersTable();
        personDao.insertUser ("Андрей", "Булдаков", 33, "And@mail.ru");
        personDao.insertUser ("Сергей", "Гром", 50,"Serg@mail.ru");
        personDao.insertUser ("Антон", "Харисов", 34,"Anton@mail.ru");
        personDao.insertUser ("Евген", "Левин", 68,"Evgen@gmail.com");
        personDao.insertUser ("Катя", "Самсонова", 52, "Cat@yandex.ru");
        personDao.insertUser ("Олеся", "Камова", 29, "Kamova@yandex.ru");
        personDao.insertUser ("Марат", "Гусеинов", 21, "GMarat@yandex.ru");

        System.out.println("-------------------------------------------------------------");
        System.out.println("Получили все поля до удаления " + personDao.getAllUsers());
        System.out.println("-------------------------------------------------------------");
        personDao.getUserById(1);
        System.out.println("-------------------------------------------------------------");
        personDao.deleteUser(2);
        System.out.println("Получили все поля после удаления " + personDao.getAllUsers());

        BookDao bookDao = new BookDao();
        bookDao.createBooksTable();
        bookDao.insertNewBook("Кинга1","Автор75", 1975);
        bookDao.insertNewBook("Книга2","Автор44", 2005);
        bookDao.insertNewBook("Книга3","Автор69", 2010);
        bookDao.insertNewBook("Книга4","Автор35", 1998);
        bookDao.insertNewBook("Книга5","Автор18", 2020);
    }
}
