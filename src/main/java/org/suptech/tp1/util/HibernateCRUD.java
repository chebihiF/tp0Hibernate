package org.suptech.tp1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class HibernateCRUD<T> implements IHibernateCRUD<T> {

    private SessionFactory factory = HibernateUtil.getFactory();
    private Session session = null ;

    public void closeSessionFactory(){
        factory.close();
    }

    private T pre_crud(String transaction_type, T t){
        try {
            session = factory.openSession();
            session.beginTransaction();

            switch (transaction_type) {
                case "save":
                    session.save(t);
                    break;
                case "update":
                    session.update(t);
                    break;
                case "delete":
                    session.delete(t);
                    break;
            }

            session.getTransaction().commit();
        }catch (Exception exception){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return t ;
    }

    @Override
    public T add(T t) throws SQLException {
        return pre_crud("save", t);
    }

    @Override
    public T update(T t) throws SQLException {
        return pre_crud("update", t);
    }

    @Override
    public T delete(T t) throws SQLException {
        return pre_crud("delete", t);
    }

    @Override
    public T get(Class _class, Serializable id) throws SQLException {
        T t = null ;
        try {
            session = factory.openSession();
            session.beginTransaction();
            t = (T) session.get(_class,id);
            session.getTransaction().commit();
        }catch (Exception exception){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return t;
    }

    @Override
    public List<T> getAll(String className) throws SQLException {
        List<T> t = null ;
        try {
            session = factory.openSession();
            session.beginTransaction();
            t = session.createQuery("from "+className).getResultList();
            session.getTransaction().commit();
        }catch (Exception exception){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return t;
    }

}
