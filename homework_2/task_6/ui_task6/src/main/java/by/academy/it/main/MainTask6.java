package by.academy.it.main;

import by.academy.it.ExpensesDaoTask6;

import java.sql.SQLException;

public class MainTask6 {
    public static void main(String[] args) {
        try {
            ExpensesDaoTask6 expenses = new ExpensesDaoTask6();
            System.out.println("First query");
            expenses.printAllReceiversWithSumExpenses();
            System.out.println("Second query");
            expenses.printSumExpensesWhenWasTheLargestPayment();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
