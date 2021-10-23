package by.academy.it;

import java.sql.*;

public class ExpensesDaoTask5 {
    private final DataSourceTask5 dataSource = new DataSourceTask5();

    public void putExpenses(String num, String date, String receiver, String value) throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement st = con.prepareStatement("INSERT INTO expenses VALUES (?, ?, ?, ?);");

        st.setString(1, num);
        st.setString(2, date);
        st.setString(3, receiver);
        st.setString(4, value);

        st.executeUpdate();
        st.close();
        con.close();
    }

    public void printTable() throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT paydate, value, name " +
                "FROM expenses,receivers WHERE receiver=receivers.num;");
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
