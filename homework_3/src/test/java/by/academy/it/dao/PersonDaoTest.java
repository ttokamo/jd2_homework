package by.academy.it.dao;

import by.academy.it.pojo.Person;
import org.hibernate.ObjectNotFoundException;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {
    PersonDao personDao;

    @org.junit.Before
    public void setUp() {
        personDao = new PersonDao();
    }

    @org.junit.After
    public void tearDown() {
        personDao = null;
    }

    @org.junit.Test
    public void addAndDeleteNewPerson() {
        Person person = new Person();
        person.setName("Alex");
        person.setSurname("Johnson");
        person.setAge(40);

        Serializable id = personDao.addNewPerson(person);

        assertEquals(person.getId(), id);
        personDao.deletePerson(person);
        assertNull(personDao.findPersonWithGet(person.getId()));
    }

    @org.junit.Test(expected = ObjectNotFoundException.class)
    public void findPersonWithLoad() {
        Person person = new Person();
        person.setName("Tokamo");
        person.setSurname("Senti");
        person.setAge(22);

        personDao.addNewPerson(person);

        personDao.deletePerson(person);
        assertNull(personDao.findPersonWithLoad(person.getId()));
    }

    @org.junit.Test
    public void readPersons() {
        List<Person> personList = personDao.readPersons();
        assertNotNull(personList);
    }
}