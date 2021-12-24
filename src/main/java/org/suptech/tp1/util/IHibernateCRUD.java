package org.suptech.tp1.util;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface IHibernateCRUD<T> {
    public T add(T t) throws SQLException;
    public T update(T t) throws SQLException;
    public T delete(T t) throws SQLException;
    public T get(Class _class, Serializable id) throws SQLException;
    public List<T> getAll(String className) throws SQLException;
}
