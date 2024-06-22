package org.example.repository;

import java.sql.DriverManager;

public class Connection {
    protected static java.sql.Connection connection;
    static String URL = "jdbc:postgresql://localhost:5432/TRPG";
    static String USERNAME = "postgres";
    static String PASSWORD = "postgres";

    public static java.sql.Connection startConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            return connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (Exception e){
            System.out.println("Connection failed");
        }
        return null;
    }
}
