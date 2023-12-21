package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablesDB {
    public static void createTables() {
        try (Connection connection = Main.getConnection();
             Statement statement = connection.createStatement()) {

            createAnimalTable(statement);
            createBirdTable(statement);
            createFishTable(statement);
            createReptileTable(statement);
            createZooTable(statement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createAnimalTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE Animal ("
                + "animalID INT PRIMARY KEY IDENTITY(1,1),"
                + "name NVARCHAR(255), "
                + "age FLOAT, "
                + "sex NVARCHAR(10))";
        statement.execute(createTableQuery);
    }

    private static void createBirdTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE Bird ("
                + "birdID INT PRIMARY KEY IDENTITY(1,1),"
                + "animalID INT REFERENCES Animal(animalID),"
                + "wingspan FLOAT, "
                + "beakType NVARCHAR(255))";
        statement.execute(createTableQuery);
    }

    private static void createFishTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE Fish ("
                + "fishID INT PRIMARY KEY IDENTITY(1,1),"
                + "animalID INT REFERENCES Animal(animalID),"
                + "scaleType NVARCHAR(255), "
                + "swimmingSpeed FLOAT)";
        statement.execute(createTableQuery);
    }

    private static void createReptileTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE Reptile ("
                + "reptileID INT PRIMARY KEY IDENTITY(1,1),"
                + "animalID INT REFERENCES Animal(animalID),"
                + "scaleType NVARCHAR(255), "
                + "tailLength FLOAT)";
        statement.execute(createTableQuery);
    }

    private static void createZooTable(Statement statement) throws SQLException {
        String createTableQuery = "CREATE TABLE Zoo ("
                + "zooID INT PRIMARY KEY IDENTITY(1,1),"
                + "name NVARCHAR(255), "
                + "countAnimals INT)";
        statement.execute(createTableQuery);
    }
}


