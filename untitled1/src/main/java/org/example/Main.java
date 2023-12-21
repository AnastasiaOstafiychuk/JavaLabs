package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Main {
    private static final String URL = "jdbc:sqlserver://DESKTOP-0NLMM1M\\MSSQLSERVER2;databaseName=animals;encrypt=true;trustServerCertificate=true;";

    private static final String USER = "sa" ;

    private static final String PASSWORD = "qwerty06";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        try {
            getConnection();
            CreateTablesDB.createTables();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}