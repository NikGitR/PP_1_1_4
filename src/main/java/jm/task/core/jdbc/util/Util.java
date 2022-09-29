package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Util {
    private static final String URL = "jdbc:MySQL://localhost/pp113";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Juu72epH";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static SessionFactory getSessionFactory () {
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        Map<String,String> settings = new HashMap<>();
        settings.put(Environment.URL, "jdbc:MySQL://localhost/pp113");
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "Juu72epH");
        standardServiceRegistryBuilder.applySettings(settings);
        StandardServiceRegistry  standardServiceRegistry = standardServiceRegistryBuilder.build();
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry).addAnnotatedClass(User.class);
        SessionFactory sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        return sessionFactory;
    }
    public static Connection getConnection (){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
        // реализуйте настройку соеденения с БД
}
