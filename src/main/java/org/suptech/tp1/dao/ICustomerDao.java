package org.suptech.tp1.dao;

import org.suptech.tp1.entities.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDao {
    public Customer addCustomer(Customer customer) throws SQLException;
    public Customer updateCustomer(Customer customer) throws SQLException;
    public Customer deleteCustomer(Customer customer) throws SQLException;
    public Customer getCustomer(Long id) throws SQLException;
    public List<Customer> getCustomers() throws SQLException;
}
