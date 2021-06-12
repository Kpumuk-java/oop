package dao;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Optional;


public class StudentDao {

    private SessionFactory factory;

    public StudentDao(SessionFactory factory) {
        this.factory = factory;
    }

    public void setFactory (SessionFactory factory) {
        this.factory = factory;
    }

    public Optional<Student> findById (Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student s = session.createQuery("select s from student s where s.id = " + id, Student.class).getSingleResult();
            session.getTransaction().commit();
            return Optional.ofNullable(s);
        }
    }

    /*
    public List<Product> findAll () {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> list = session.createQuery("select p from products p", Product.class).getResultList();
            session.getTransaction().commit();
            return list;
        }
    }

    public void deleteById (Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product p = session.get(Product.class, id);
            session.delete(p);
            session.getTransaction().commit();
        }
    }

    public Product saveOrUpdate (Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }*/
}
