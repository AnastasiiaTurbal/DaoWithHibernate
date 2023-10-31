package jm.task.core.jdbc.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;

public class Util {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/task";
    private static final String DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(jm.task.core.jdbc.model.User.class)
                    .setProperty("hibernate.connection.driver-class", DRIVER)
                    .setProperty("hibernate.connection.url", URL)
                    .setProperty("hibernate.connection.username", USER_NAME)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .setProperty("hibernate.dialect", DIALECT)
                    .buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

}
