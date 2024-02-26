package org.example.jdbc;

import java.sql.*;

public class BankService {


    private static Connection connection;

    private static BankService bank = new BankService();

    public BankService() {
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
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("CONNECTED");
        } catch(Exception e) {
            e.printStackTrace();
        }
        // End try-catch
    }

    public static void main(String[] args) {
        bank.readDocuments();
        bank.insert(new BankAccount("2232132","3232133","DK","Paris",4312));
        bank.readDocuments();

    }

    private void insert(BankAccount bankAccount) {
        String statement = "INSERT INTO BANK_TABLE "
                + "(BRANCH_CODE, ACCOUNT_NUMBER,"
                + "CUST_NAME, CUST_ADDRESS, BALANCE) "
                + "VALUES (?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(statement)) {
            ps.setString(1,bankAccount.getBranchCode());
            ps.setString(2,bankAccount.getAccountNo());
            ps.setString(3,bankAccount.getCustName());
            ps.setString(4,bankAccount.getCustAddress());
            ps.setDouble(5,bankAccount.getBalance());
            int isInserted = ps.executeUpdate();
            if (isInserted==1) {
                System.out.println("New data successfully inserted");
            } else {
                System.out.println("Some Error occurred during insertion");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void readDocuments() {
        String statement = "SELECT * FROM BANK_TABLE";
        try(PreparedStatement ps = connection.prepareStatement(statement)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BankAccount bankAccount = new BankAccount(
                        rs.getString("BRANCH_CODE"),
                        rs.getString("ACCOUNT_NUMBER"),
                        rs.getString("CUST_NAME"),
                        rs.getString("CUST_ADDRESS"),
                        rs.getDouble("BALANCE")
                );
                System.out.println(bankAccount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
