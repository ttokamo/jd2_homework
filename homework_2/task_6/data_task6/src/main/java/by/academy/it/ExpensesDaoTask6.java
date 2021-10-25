package by.academy.it;

import java.sql.*;
import java.util.List;

public class ExpensesDaoTask6 {
    DataSourceTask6 dataSource = new DataSourceTask6();

    public void printAllReceiversWithSumExpenses() throws SQLException {
        Connection con = dataSource.getConnection();
        String sql =
                "SELECT name, SUM(value) AS sum " +
                "FROM receivers r, expenses " +
                "WHERE receiver = r.num " +
                "GROUP BY name";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                    "| "
                    + rs.getString("name") + " | "
                    + rs.getString("sum") + " |"
            );
        }
    }

    public void printSumExpensesWhenWasTheLargestPayment() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        String sql =
                "SELECT paydate, SUM(value) as sum " +
                "FROM expenses " +
                "WHERE paydate IN (" +
                        "SELECT paydate " +
                        "FROM expenses " +
                        "WHERE value = (" +
                                "SELECT MAX(value) " +
                                "FROM expenses)) " +
                "GROUP BY paydate;";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                    "| "
                    + rs.getString("paydate") + " | "
                    + rs.getString("sum") + " | "
            );
        }

        st.close();
        con.close();
    }
}
