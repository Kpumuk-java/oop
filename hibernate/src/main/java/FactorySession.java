import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactorySession {

    private SessionFactory factory;

    public void init() {
        try{
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();}
        catch (HibernateException exception) {
            System.out.println("Problem creating session factory");
            exception.printStackTrace();
        }
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void shutDown () {
        factory.close();
    }
}
