package by.academy.it.util;

import by.academy.it.pojo.Person;

public class MessagesUtil {
    public static void userNotExist() {
        System.out.println("The specified user does not exist");
    }

    public static void userAdded(Person person) {
        System.out.println("User successfully added with id = " + person.getId());
    }

    public static void userDeleted() {
        System.out.println("User successfully deleted");
    }

    public static void userAddedAndDeleted() {
        System.out.println("User successfully added and deleted");
    }
}
