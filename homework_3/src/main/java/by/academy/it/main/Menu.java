package by.academy.it.main;

public class Menu {
    private static final String[] startMenu = new String[]{
            "Add new person",
            "Delete person",
            "Find person",
            "Print all persons",
            "Exit"
    };

    public static void showMenu() {
        for (int i = 1; i <= startMenu.length; i++) {
            System.out.print(i + ". " + startMenu[i - 1] + " | ");
        }
        System.out.println();
    }

}
