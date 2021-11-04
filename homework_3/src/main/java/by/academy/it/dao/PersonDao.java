package by.academy.it.dao;

import by.academy.it.pojo.Person;
import by.academy.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDao {

    public void addNewPerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public void deletePerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(person);
        transaction.commit();
        session.close();
    }

    public Person findPerson(int id) {
        Session session = HibernateUtil.getSession();
        return session.get(Person.class, id);
    }

    public List<Person> readPersons() {
        Session session = HibernateUtil.getSession();
        List<Person> personList =
                session.createQuery("from Person", Person.class).list();
        session.close();
        return personList;
    }
}
