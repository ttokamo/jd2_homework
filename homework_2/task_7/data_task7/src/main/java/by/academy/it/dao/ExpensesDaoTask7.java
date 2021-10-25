package by.academy.it.dao;

import by.academy.it.data.DataSourceTask7;
import by.academy.it.dto.Expense;
import by.academy.it.dto.Receiver;

import java.sql.*;
import java.util.ArrayList;

public class ExpensesDaoTask7 implements Dao {
    DataSourceTask7 dataSource = new DataSourceTask7();

    @Override
    public Receiver getReceiver(int num) throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM receivers WHERE num = ?");
        st.setInt(1, num);
        ResultSet rs = st.executeQuery();
        Receiver receiver = null;

        while (rs.next()) {
            receiver = new Receiver();
            receiver.setName(rs.getString("name"));
            receiver.setNum(rs.getInt("num"));
        }

        st.close();
        con.close();
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM receivers;");
        ArrayList<Receiver> list = new ArrayList<>();
        Receiver receiver;

        while (rs.next()){
            receiver = new Receiver();
            receiver.setNum(rs.getInt("num"));
            receiver.setName(rs.getString("name"));
            list.add(receiver);
        }
        st.close();
        con.close();
        return list;
    }

    @Override
    public Expense getExpense(int num) throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM expenses WHERE num = ?");
        st.setInt(1, num);
        ResultSet rs = st.executeQuery();
        Expense expense = null;

        while (rs.next()) {
            expense = new Expense();
            expense.setNum(rs.getInt("num"));
            expense.setPaydate(rs.getString("paydate"));
            expense.setReceiver(rs.getString("receiver"));
            expense.setValue(rs.getDouble("value"));
        }

        st.close();
        con.close();
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM expenses;");
        ArrayList<Expense> list = new ArrayList<>();
        Expense expense;

        while (rs.next()){
            expense = new Expense();
            expense.setNum(rs.getInt("num"));
            expense.setPaydate(rs.getDate("paydate").toString());
            expense.setReceiver(rs.getString("receiver"));
            expense.setValue(rs.getDouble("value"));
            list.add(expense);
        }

        st.close();
        con.close();
        return list;
    }

    @Override
    public int addReceiver(Receiver receiver) throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement st = con.prepareStatement("INSERT INTO receivers (num, name) VALUES (?, ?)");
        st.setInt(1, receiver.getNum());
        st.setString(2, receiver.getName());
        int count =  st.executeUpdate();
        st.close();
        con.close();
        return count;
    }

    @Override
    public int addExpense(Expense expense) throws SQLException {
        Connection con = dataSource.getConnection();
        PreparedStatement st = con.prepareStatement("INSERT INTO expenses (num, paydate, receiver, value) VALUES (?, ?, ?, ?)");
        st.setInt(1, expense.getNum());
        st.setString(2, expense.getPaydate());
        st.setString(3, expense.getReceiver());
        st.setDouble(4, expense.getValue());
        int count =  st.executeUpdate();
        st.close();
        con.close();
        return count;
    }
}
