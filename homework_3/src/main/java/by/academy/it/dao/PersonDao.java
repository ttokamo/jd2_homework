package by.academy.it.dao;

import by.academy.it.pojo.Person;
import by.academy.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class PersonDao {

    public Serializable addNewPerson(Person person) {
        Session session = HibernateUtil.getSession();
        Serializable id = null;
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            id = session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return id;
    }

    public void deletePerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void addAndDeletePerson(Person person) {
        addNewPerson(person);
        deletePerson(person);
    }

    public Person findPersonWithGet(int id) {
        Session session = HibernateUtil.getSession();
        return session.get(Person.class, id);
    }

    public Person findPersonWithLoad(int id) {
        Session session = HibernateUtil.getSession();
        return session.load(Person.class, id);
    }

    public List<Person> readPersons() {
        Session session = HibernateUtil.getSession();
        List<Person> personList =
                session.createQuery("from Person", Person.class).list();
        session.close();
        return personList;
    }
}
