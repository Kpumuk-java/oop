import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FactorySession {

    private SessionFactory factory;

    public void init() {
        try{
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        }
        catch (HibernateException exception) {
            System.out.println("Problem creating session factory");
            exception.printStackTrace();
        }

        /*Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
         factory = configuration.buildSessionFactory(builder.build());*/

    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void shutDown () {
        factory.close();
    }
}
