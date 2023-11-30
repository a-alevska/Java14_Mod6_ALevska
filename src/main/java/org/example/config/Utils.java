package org.example.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {
    public static void queriesReader(Connection connection, BufferedReader reader) throws IOException, SQLException {
        StringBuilder sqlQuery = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sqlQuery.append(line).append(" ");
        }

        Statement statement = connection.createStatement();
        statement.execute(sqlQuery.toString());

        statement.close();
        connection.close();
        reader.close();

        System.out.println("SQL-queries all done successfully.");
    }
}
