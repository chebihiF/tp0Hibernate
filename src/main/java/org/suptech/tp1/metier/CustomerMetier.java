package org.suptech.tp1.metier;

import org.suptech.tp1.dao.CustomerDao;
import org.suptech.tp1.dao.ICustomerDao;
import org.suptech.tp1.dao.NewCustomerDao;
import org.suptech.tp1.entities.Customer;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

public class CustomerMetier implements ICustomerMetier{

    private ICustomerDao dao;

    public void setDao(ICustomerDao dao) {
        //IOC
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("applicationContext")));
            String StringClassName = br.readLine();
            Class DaoCalss = Class.forName(StringClassName); //Charger dynamiquement la class StringClassName
            dao = (ICustomerDao) DaoCalss.newInstance();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.dao = dao;
    }

    @Override
    public Customer addCustomer(Customer customer) throws SQLException {
        if(!customer.getEmail().contains("@"))
            throw new RuntimeException("email invalid");
        return dao.addCustomer(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws SQLException {
        return dao.updateCustomer(customer);
    }

    @Override
    public Customer deleteCustomer(Customer customer) throws SQLException {
        return dao.deleteCustomer(customer);
    }

    @Override
    public Customer getCustomer(Long id) throws SQLException {
        return dao.getCustomer(id);
    }

    @Override
    public List<Customer> getCustomers() throws SQLException {
        return dao.getCustomers();
    }
}
