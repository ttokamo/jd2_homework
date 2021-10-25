package by.academy.it;

import java.sql.*;

public class ExpensesDaoTask4 {
    private final DataSourceTask4 dataSourceTask4 = new DataSourceTask4();

    public void addExpense(String date, String receiver, Double value) throws SQLException {
        Connection con = dataSourceTask4.getConnection();
        Statement st = con.createStatement();
        String sql = "INSERT INTO expenses (paydate, receiver, value) VALUES ("
                + "'"
                + date + "',"
                + receiver + ","
                + value + ");";
        st.executeUpdate(sql);
        st.close();
        con.close();
    }

    public void printTable() throws SQLException {
        Connection con = dataSourceTask4.getConnection();
        Statement st = con.createStatement();
        String sql =
                "SELECT paydate, value, name " +
                "FROM expenses, receivers " +
                "WHERE receiver=receivers.num;";
        ResultSet rs = st.executeQuery(sql);

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
