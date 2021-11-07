package by.academy.it.main;

import by.academy.it.dao.PersonDao;
import by.academy.it.input.InputUtil;
import by.academy.it.pojo.Person;
import by.academy.it.util.MessagesUtil;
import org.hibernate.ObjectNotFoundException;

public class Main {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person;
        boolean workStatus = true;

        while (workStatus) {
            Menu.showStartMenu();
            switch (InputUtil.inputDigit()) {

                case 1: //Добавить пользователя
                    person = new Person();
                    person.setName(InputUtil.inputName());
                    person.setSurname(InputUtil.inputSurname());
                    person.setAge(InputUtil.inputAge());
                    Menu.showAddOrAddAndDeleteMenu();
                    switch (InputUtil.inputDigit()) {
                        case 1:
                            personDao.addNewPerson(person);
                            MessagesUtil.userAdded(person);
                            break;
                        case 2:
                            personDao.addAndDeletePerson(person);
                            MessagesUtil.userAddedAndDeleted();
                            break;
                    }
                    break;

                case 2: // Удалить пользователя
                    person = personDao.findPersonWithGet(InputUtil.inputId());
                    if (person == null) {
                        MessagesUtil.userNotExist();
                    } else {
                        personDao.deletePerson(person);
                        MessagesUtil.userDeleted();
                    }
                    break;

                case 3:// Найти пользователя(Get)
                    person = personDao.findPersonWithGet(InputUtil.inputId());
                    if (person == null) {
                        MessagesUtil.userNotExist();
                    } else {
                        System.out.println(person);
                    }
                    break;

                case 4: // Найти пользователя(Load)
                    try {
                        person = personDao.findPersonWithLoad(InputUtil.inputId());
                        System.out.println(person);
                    } catch (ObjectNotFoundException e) {
                        MessagesUtil.userNotExist();
                    }
                    break;

                case 5: // Вывести список пользователей
                    personDao.readPersons().forEach(System.out::println);
                    break;

                case 6: // Завершить работу программы
                    workStatus = false;
                    break;
            }
        }
    }
}
