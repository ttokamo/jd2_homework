package by.academy.it;

import java.sql.*;

public class ExpensesDaoTask5 {
    private final DataSourceTask5 dataSource = new DataSourceTask5();

    public void addExpense(String date, String receiver, Double value) throws SQLException {
        Connection con = dataSource.getConnection();
        String sql = "INSERT INTO expenses (paydate, receiver, value) VALUES (?, ?, ?);";
        PreparedStatement st = con.prepareStatement(sql);

        st.setDate(1, Date.valueOf(date));
        st.setString(2, receiver);
        st.setDouble(3, value);

        st.executeUpdate();
        st.close();
        con.close();
    }

    public void printTable() throws SQLException {
        Connection con = dataSource.getConnection();
        String sql =
                "SELECT paydate, value, name " +
                "FROM expenses,receivers " +
                "WHERE receiver = receivers.num;";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println("| "
                    + rs.getDate("paydate") + " | "
                    + rs.getDouble("value") + " | "
                    + rs.getString("name") + " |"
            );
        }

        st.close();
        con.close();
    }
}
