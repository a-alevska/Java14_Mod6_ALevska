package org.example.queries;

import org.example.config.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStmntDatabaseInitService {

    public static final String CREATE_ENUM = "CREATE TYPE LEVEL AS ENUM ('Trainee','Junior','Middle','Senior');";

    public static final String PREPARED_STATEMENT_CREATE_WORKER = "CREATE TABLE worker\n" +
            "(\n" +
            "    ID       SERIAL PRIMARY KEY,\n" +
            "    NAME     VARCHAR(1000) CHECK ( length(NAME) > 1 ) NOT NULL,\n" +
            "    BIRTHDAY DATE CHECK ( date_part('year', BIRTHDAY) > 1900 ),\n" +
            "    LEVEL    LEVEL                                    NOT NULL,\n" +
            "    SALARY   int CHECK ( SALARY > 100 AND SALARY < 100000 )\n" +
            ");";

    public static final String PREPARED_STATEMENT_CREATE_CLIENT = "CREATE TABLE client\n" +
            "(\n" +
            "    ID       SERIAL PRIMARY KEY,\n" +
            "    NAME     VARCHAR(1000) CHECK ( length(NAME) > 1 ) NOT NULL\n" +
            ");";

    public static final String PREPARED_STATEMENT_CREATE_PROJECT = "CREATE TABLE project\n" +
            "(\n" +
            "    ID       SERIAL PRIMARY KEY,\n" +
            "    CLIENT_ID INT REFERENCES client(ID),\n" +
            "    START_DATE DATE,\n" +
            "    FINISH_DATE DATE\n" +
            ");";

    public static final String PREPARED_STATEMENT_CREATE_PROJECT_WORKER = "CREATE TABLE project_worker\n" +
            "(\n" +
            "    PROJECT_ID INT REFERENCES project(ID),\n" +
            "    WORKER_ID INT REFERENCES worker(ID),\n" +
            "    CONSTRAINT project_worker_pk PRIMARY KEY (PROJECT_ID, WORKER_ID)\n" +
            ");";

    public void dbInit() {
        try {
            Connection connection = Database.get_instance().getConnection();

            PreparedStatement prepareStatement = connection.prepareStatement(CREATE_ENUM + "\n" + PREPARED_STATEMENT_CREATE_WORKER +
                    "\n" + PREPARED_STATEMENT_CREATE_CLIENT + "\n" + PREPARED_STATEMENT_CREATE_PROJECT +
                    "\n" + PREPARED_STATEMENT_CREATE_PROJECT_WORKER);
            prepareStatement.execute();
            prepareStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
