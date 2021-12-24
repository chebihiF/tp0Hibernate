package org.suptech.tp1.dao;

import org.suptech.tp1.entities.Customer;
import org.suptech.tp1.util.HibernateCRUD;

import java.sql.SQLException;
import java.util.List;

public class CustomerDao implements ICustomerDao{

    HibernateCRUD<Customer> crud = new HibernateCRUD<>();

    @Override
    public Customer addCustomer(Customer customer) throws SQLException {
        return crud.add(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws SQLException {
        return crud.update(customer);
    }

    @Override
    public Customer deleteCustomer(Customer customer) throws SQLException {
        return crud.delete(customer);
    }

    @Override
    public Customer getCustomer(Long id) throws SQLException {
        return crud.get(Customer.class,id);
    }

    @Override
    public List<Customer> getCustomers() throws SQLException {
        return crud.getAll("Customer");
    }
}
