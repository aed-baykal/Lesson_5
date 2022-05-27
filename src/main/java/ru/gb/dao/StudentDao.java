package ru.gb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.gb.model.Student;

import java.util.List;

public class StudentDao {

    SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> findAll() {
        List<Student> students;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            students = session.createQuery("select p from Student p", Student.class).getResultList();
            session.getTransaction().commit();
        }
        return students;
    }

    public Student findStudentById(Long id) {
        Student student;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            student = session.get(Student.class, id);
            session.getTransaction().commit();
        }
        return student;
    }

    public void deleteStudentById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            Student student = session.load(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }
}
