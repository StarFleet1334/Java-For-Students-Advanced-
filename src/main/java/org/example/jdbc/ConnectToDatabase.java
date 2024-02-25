package org.example.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 *  -> JDBC URL:
 *      - protocol: subprotocol: subname
 *      - protocol is always jdbc
 *      - subprotocol is the vendor or product name - derby
 *          - mysql,oracle,postgresql
 *      - subname is the database connection details:
 *   Examples:
 *   -> jdbc:derby://localhost:1527//BANK_DB - including the port
 *   -> jdbc:derby://localhost/BANK_DB - port is optional when using localhost
 *   -> jdbc:derby://127.0.0.1/BANK_DB - ip address for localhost
 *
 *
 *
 *
 */

public class ConnectToDatabase {
    private static Connection con;


    public ConnectToDatabase() throws SQLException {
        // Database URL in the format jdbc:mysql://hostname:port/databaseName
        String url = "jdbc:mysql://localhost:3306/sys";
        // Database credentials
        // provide your user and password
        String user = "";
        String password = "";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("CONNECTED");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        // End try-catch
    }

    public static void main(String[] args) throws SQLException {
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
    }
}
