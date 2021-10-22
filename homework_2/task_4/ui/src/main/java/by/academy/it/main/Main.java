package by.academy.it.main;

import by.academy.it.ExpensesDao;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ExpensesDao expensesDao = new ExpensesDao();
            if (args.length == 4) {
                expensesDao.putExpenses(args[0], args[1], args[2], args[3]);
                expensesDao.printTable();
            } else {
                System.out.println("Invalid number of parameters");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
