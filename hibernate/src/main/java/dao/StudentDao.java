package dao;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
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
            Student s = session.createQuery("Select s from student s where id = " + id, Student.class).getSingleResult();
            session.getTransaction().commit();
            return Optional.ofNullable(s);
        }
    }


    public List<Student> findAll () {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> list = session.createQuery("select s from student s", Student.class).getResultList();
            session.getTransaction().commit();
            return list;
        }
    }

    public void deleteById (Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student s = session.get(Student.class, id);
            session.delete(s);
            session.getTransaction().commit();
        }
    }

    public Student saveOrUpdate (Student student) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
            return student;
        }
    }
}
