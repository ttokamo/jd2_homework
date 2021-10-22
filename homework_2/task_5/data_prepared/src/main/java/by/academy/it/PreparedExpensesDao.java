package by.academy.it;

import java.sql.*;

public class PreparedExpensesDao {
    private final PreparedDataSource dataSource = new PreparedDataSource();

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
        PreparedStatement st = con.prepareStatement("SELECT * FROM expenses;");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getString(1) + " "
                    + rs.getDate(2) + " "
                    + rs.getString(3) + " "
                    + rs.getDouble(4) + " "
            );
        }

        st.close();
        con.close();
    }
}
