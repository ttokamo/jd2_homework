package by.academy.it.main;

import by.academy.it.dao.PersonDao;
import by.academy.it.pojo.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person;
        boolean workStatus = true;

        while (workStatus) {
            Menu.showMenu();
            switch (inputDigit()) {
                case 1: //Добавить пользователя
                    person = new Person();
                    System.out.println("Input name");
                    person.setName(inputText());
                    System.out.println("Input surname");
                    person.setSurname(inputText());
                    System.out.println("Input age");
                    person.setAge(inputDigit());
                    personDao.addNewPerson(person);
                    System.out.println("User successfully added with id = " + person.getId());
                    break;
                case 2: // Удалить пользователя
                    System.out.println("Input id");
                    person = personDao.findPerson(inputDigit());
                    if (person == null) {
                        System.out.println("The specified user does not exist");
                    } else {
                        personDao.deletePerson(person);
                        System.out.println("User successfully deleted");
                    }
                    break;
                case 3: // Найти пользователя
                    System.out.println("Input id");
                    person = personDao.findPerson(inputDigit());
                    if (person == null) {
                        System.out.println("The specified user does not exist");
                    } else {
                        System.out.println(person);
                    }
                    break;
                case 4: // Вывести список пользователей
                    personDao.readPersons().forEach(System.out::println);
                    break;
                case 5: // Завершить работу программы
                    workStatus = false;
                    break;
            }
        }
    }

    public static int inputDigit() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String inputText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
