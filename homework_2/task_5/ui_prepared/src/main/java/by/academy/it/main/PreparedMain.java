package by.academy.it.main;

import by.academy.it.PreparedExpensesDao;
import java.sql.SQLException;

public class PreparedMain {
    public static void main(String[] args) {
        try {
            PreparedExpensesDao expensesDao = new PreparedExpensesDao();
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
