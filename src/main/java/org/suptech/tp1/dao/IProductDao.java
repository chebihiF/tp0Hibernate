package org.suptech.tp1.dao;

import org.suptech.tp1.entities.Customer;
import org.suptech.tp1.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    public Product addProduct(Product product) throws SQLException;
    public Product updateProduct(Product product) throws SQLException;
    public Product deleteProduct(Product product) throws SQLException;
    public Product getProduct(Long id) throws SQLException;
    public List<Product> getProducts() throws SQLException;
}
