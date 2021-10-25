package by.academy.it.main;

import by.academy.it.dao.ExpensesDaoTask7;
import by.academy.it.dto.Expense;
import by.academy.it.dto.Receiver;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;


public class MainTask7 {
    public static void main(String[] args) throws SQLException {
        ExpensesDaoTask7 expensesDaoTask7 = new ExpensesDaoTask7();

        //Expenses
        Expense expense = new Expense();
        expense.setPaydate("2020-10-10");
        expense.setReceiver("5");
        expense.setValue(80000.0);
        expensesDaoTask7.addExpense(expense);

        expense.setPaydate("2021-07-02");
        expense.setReceiver("3");
        expense.setValue(10000.0);
        expensesDaoTask7.addExpense(expense);

        System.out.println(expensesDaoTask7.getExpense(2));
        System.out.println();

        ArrayList<Expense> expenses = expensesDaoTask7.getExpenses();
        expenses.forEach(System.out::println);

        //Receivers
        Receiver receiver = new Receiver();
        try {
            receiver.setNum(5);
            receiver.setName("BIGZ");
            expensesDaoTask7.addReceiver(receiver);

            receiver.setNum(7);
            receiver.setName("ProStore");
            expensesDaoTask7.addReceiver(receiver);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("This number already exist");
        }

        System.out.println(expensesDaoTask7.getReceiver(2));
        System.out.println();

        ArrayList<Receiver> receivers = expensesDaoTask7.getReceivers();
        receivers.forEach(System.out::println);

    }
}
