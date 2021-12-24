package org.suptech.tp1.dao;

import org.suptech.tp1.entities.Product;
import org.suptech.tp1.util.HibernateCRUD;

import java.sql.SQLException;
import java.util.List;

public class ProductDao implements IProductDao{

    HibernateCRUD<Product> crud = new HibernateCRUD<>();

    @Override
    public Product addProduct(Product product) throws SQLException {
        return crud.add(product);
    }

    @Override
    public Product updateProduct(Product product) throws SQLException {
        return crud.update(product);
    }

    @Override
    public Product deleteProduct(Product product) throws SQLException {
        return crud.delete(product);
    }

    @Override
    public Product getProduct(Long id) throws SQLException {
        return crud.get(Product.class,id);
    }

    @Override
    public List<Product> getProducts() throws SQLException {
        return crud.getAll("Product");
    }
}
