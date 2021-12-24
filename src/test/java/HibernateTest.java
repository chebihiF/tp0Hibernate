import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.suptech.tp1.entities.Customer;
import org.suptech.tp1.util.HibernateUtil;

import java.util.List;

public class HibernateTest {

    @Test
    public void connection(){
        HibernateUtil.getFactory();
    }

    @Test
    public void addCustomer(){
        SessionFactory factory = null ;
        Session session = null ;
        try {
            factory = HibernateUtil.getFactory();
            session = factory.openSession();
            session.beginTransaction();
            session.save(new Customer(null, "sanaa", "sanaa@gmail.com"));
            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
            factory.close();
        }

    }

    @Test
    public void updateCustomer(){
        SessionFactory factory = null ;
        Session session = null ;
        try {
            factory = HibernateUtil.getFactory();

            if(!session.isOpen())
                session = factory.openSession();
            else
                session = factory.getCurrentSession();

            session.beginTransaction();
            session.update(new Customer(1L, "chebihi", "f.chebihi@gmail.com"));
            session.getTransaction().commit();
        }catch (Exception exception){
            exception.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
            factory.close();
        }
    }

    @Test
    public void deleteCustomer() {
        SessionFactory factory = null;
        Session session = null;
        try {
            factory = HibernateUtil.getFactory();
            session = factory.openSession();
            session.beginTransaction();
            session.delete(new Customer(1L, "chebihi", "f.chebihi@gmail.com"));
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            factory.close();
        }
    }

    @Test
    public void getCustomerById(){
        SessionFactory factory = null;
        Session session = null;
        Customer customer = null ;
        try {
            factory = HibernateUtil.getFactory();
            session = factory.openSession();
            session.beginTransaction();
            customer = session.get(Customer.class,2L);
            System.out.println(customer);
            Assert.assertEquals(customer.getId().intValue(),2);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            factory.close();
        }
    }

    @Test
    public void getCustomerByEmail(){
        SessionFactory factory = null;
        Session session = null;
        Customer customer = null ;
        try {
            factory = HibernateUtil.getFactory();
            session = factory.openSession();
            session.beginTransaction();
            customer = (Customer) session.createQuery("from Customer c where c.email = 'chebihi@gmail.com'").getSingleResult(); //HQL
            Assert.assertNotEquals(customer,null);
            System.out.println(customer);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            factory.close();
        }
    }

    @Test
    public void getCustomers(){
        SessionFactory factory = null;
        Session session = null;
        List<Customer> customers = null ;
        try {
            factory = HibernateUtil.getFactory();
            session = factory.openSession();
            session.beginTransaction();
            customers = session.createQuery("from Customer c").getResultList(); //HQL
            Assert.assertEquals(customers.size(),2);

            for(Customer customer : customers)
                System.out.println(customer);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            factory.close();
        }
    }



}
