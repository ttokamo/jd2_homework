package by.academy.it;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    public DataSource() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver connection error");
        }
    }

    protected Connection getConnection() {
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
