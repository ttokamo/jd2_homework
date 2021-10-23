package by.academy.it.main;

import by.academy.it.ExpensesDaoTask4;
import java.sql.SQLException;

public class MainTask4 {
    public static void main(String[] args) {
        try {
            ExpensesDaoTask4 expensesDaoTask4 = new ExpensesDaoTask4();
            if (args.length == 4) {
                expensesDaoTask4.putExpenses(args[0], args[1], args[2], args[3]);
                expensesDaoTask4.printTable();
            } else {
                System.out.println("Invalid number of parameters");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
