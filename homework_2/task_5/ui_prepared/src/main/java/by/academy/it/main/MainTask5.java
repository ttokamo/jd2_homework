package by.academy.it.main;

import by.academy.it.ExpensesDaoTask5;
import java.sql.SQLException;

public class MainTask5 {
    public static void main(String[] args) {
        try {
            ExpensesDaoTask5 expensesDao = new ExpensesDaoTask5();
            if (args.length == 4) {
                expensesDao.addExpense(args[0], args[1], args[2], args[3]);
                expensesDao.printTable();
            } else {
                System.out.println("Invalid number of parameters");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
