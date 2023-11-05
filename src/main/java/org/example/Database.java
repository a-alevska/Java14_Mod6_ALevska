package org.example;

import java.sql.*;

public class Database {
    private static Database database_instance = null;
    private Connection connection;
    private Database(){
        String dbUrl = "org.postgresql:postgresql:42.6.0";
        String dbUser = "user";
        String dbPass = "password";

        try{Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            Statement stmt = conn.createStatement();
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
