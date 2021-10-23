package by.academy.it;

import java.sql.*;

public class ExpensesDaoTask4 {
    private final DataSourceTask4 dataSourceTask4 = new DataSourceTask4();

    public void addExpense(String num, String date, String receiver, String value) throws SQLException {
        Connection con = dataSourceTask4.getConnection();
        Statement st = con.createStatement();

        st.executeUpdate("INSERT INTO expenses (num, paydate, receiver, value) VALUES ("
                + num + ",'"
                + date + "',"
                + receiver + ","
                + value + ");"
        );

        st.close();
        con.close();
    }

    public void printTable() throws SQLException {
        Connection con = dataSourceTask4.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT paydate, value, name FROM expenses, " +
                "receivers WHERE receiver=receivers.num;");

        while (rs.next()) {
            System.out.println("| "
                    + rs.getDate("paydate") + " | "
                    + rs.getDouble("value") + " | "
                    + rs.getString("name") + " | "
            );
        }

        st.close();
        con.close();
    }
}
