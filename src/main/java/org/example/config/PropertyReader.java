package org.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getConnectionUrlForPostgres() {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("app.properties")) {

            java.util.Properties prop = new java.util.Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return null;
            }

            prop.load(input);

            return "jdbc:postgresql://" +
                    prop.getProperty("postgres.db.host") +
                    ":" +
                    prop.getProperty("postgres.db.port") +
                    "/" +
                    prop.getProperty("postgres.db.database") +
                    "?currentSchema=test1";
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static String getUserForPostgres() {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("app.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return null;
            }

            prop.load(input);

            return prop.getProperty("postgres.db.username");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static String getPasswordForPostgres() {
        try (InputStream input = PropertyReader.class.getClassLoader()
                .getResourceAsStream("app.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return null;
            }

            prop.load(input);

            return prop.getProperty("postgres.db.password");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
