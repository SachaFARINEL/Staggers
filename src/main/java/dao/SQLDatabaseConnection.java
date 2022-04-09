package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://localhost\\SQLEXPRESS;database=dbstage;"
                        + "user=sacha;"
                        + "password=sio;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;";


        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            System.out.println("yes");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}