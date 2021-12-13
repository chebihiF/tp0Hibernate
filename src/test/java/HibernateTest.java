import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.suptech.tp1.entities.Customer;
import org.suptech.tp1.util.HibernateUtil;

public class HibernateTest {

    @Test
    public void connection(){
        HibernateUtil.getFactory();
    }

    @Test
    public void addCustomer(){
        SessionFactory factory = HibernateUtil.getFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(new Customer(null,"chebihi","chebihi@gmail.com"));
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

}
