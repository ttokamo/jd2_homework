package by.academy.it.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    static SessionFactory sessionFactory;

    public static Session getSession() {
        if (sessionFactory == null) {
            StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            sessionFactory = new MetadataSources(reg)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
}
