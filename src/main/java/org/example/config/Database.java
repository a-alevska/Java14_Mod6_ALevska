package org.example.config;

import lombok.Getter;
import org.flywaydb.core.Flyway;

import java.sql.*;

@Getter
public class Database {

    private static final Database INSTANCE = new Database();

    private Connection PostgresConnection;
    private Database() {

        try {
            String postgresConnectionUrl = PropertyReader.getConnectionUrlForPostgres();
            String username = PropertyReader.getUserForPostgres();
            String password = PropertyReader.getPasswordForPostgres();
            assert postgresConnectionUrl != null;
            this.PostgresConnection = DriverManager.getConnection(postgresConnectionUrl, username, password);
            flywayMigration(postgresConnectionUrl, username, password);
        } catch (SQLException e) {
            System.out.println("Create connection exception:" + e.getMessage());
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    private void flywayMigration(String connectionUrl, String username, String password) {
        Flyway flyway = Flyway.configure().dataSource(connectionUrl, username, password)
                .locations("classpath:/flyway_migration").load();
        flyway.migrate();
    }
}

