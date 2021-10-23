package by.academy.it;

import java.sql.*;

public class ExpensesDao {
    private final DataSource dataSource = new DataSource();

    public void putExpenses(String num, String date, String receiver, String value) throws SQLException {
        Connection con = dataSource.getConnection();
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
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM expenses;");

        while (rs.next()) {
            System.out.println(
                    rs.getString(1) + " "
                    + rs.getString(2) + " "
                    + rs.getString(3) + " "
                    + rs.getDouble(4) + " "
            );
        }

        st.close();
        con.close();
    }
}
