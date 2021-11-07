package by.academy.it.input;

import java.util.Scanner;

public class InputUtil {

    public static int inputDigit() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name");
        return scanner.nextLine();
    }

    public static String inputSurname() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input surname");
        return scanner.nextLine();
    }

    public static int inputAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input age");
        return scanner.nextInt();
    }

    public static int inputId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input id");
        return scanner.nextInt();
    }
}
