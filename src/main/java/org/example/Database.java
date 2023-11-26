package org.example;

import java.sql.*;

public class Database {
    private static Database database_instance;
    private Connection connection;
    private Database(){
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUser = "postgres";
        String dbPass = "postgres";

        try{
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        }catch (SQLException e) {
            e.printStackTrace();
        }
}


    public static synchronized Database get_instance(){
        if (database_instance == null)
            database_instance = new Database();

        return database_instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
