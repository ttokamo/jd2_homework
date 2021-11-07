package by.academy.it.main;

public class Menu {
    private static final String[] startMenu = new String[]{
            "Add new person",
            "Delete person",
            "Find person(get)",
            "Find person(load)",
            "Print all persons",
            "Exit"
    };

    private static final String[] addOrAddAndDeleteMenu = new String[]{
            "Add",
            "Add and delete"
    };

    public static void showStartMenu() {
        for (int i = 1; i <= startMenu.length; i++) {
            System.out.print(i + ". " + startMenu[i - 1] + " | ");
        }
        System.out.println();
    }

    public static void showAddOrAddAndDeleteMenu() {
        for (int i = 1; i <= addOrAddAndDeleteMenu.length; i++) {
            System.out.print(i + ". " + addOrAddAndDeleteMenu[i - 1] + " | ");
        }
        System.out.println();
    }

}
