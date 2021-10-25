package by.academy.it.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceTask7 {
    public DataSourceTask7() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver connection error");
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ListExpenses",
                    "root",
                    "root"
            );
        } catch (SQLException e) {
            System.out.println("Database connection error");
        }
        return connection;
    }
}
