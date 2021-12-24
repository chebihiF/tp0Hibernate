package org.suptech.tp1.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.suptech.tp1.entities.Customer;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
       factory = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
