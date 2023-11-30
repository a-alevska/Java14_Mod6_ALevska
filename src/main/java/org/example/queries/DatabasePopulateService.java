package org.example.queries;

import org.example.config.Database;
import org.example.config.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.get_instance().getConnection();

            BufferedReader reader = new BufferedReader(new FileReader("sql/populate_db.sql"));
            Utils.queriesReader(connection, reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
