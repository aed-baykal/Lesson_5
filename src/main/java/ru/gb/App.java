package ru.gb;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.dao.StudentDao;
import ru.gb.model.Student;

public class App {
    public static void main(String[] args) {

        SessionFactory sessionFactory = getSessionFactory();
        StudentDao studentDao = new StudentDao(sessionFactory);

        for (int i = 0; i < 1000; i++) {
            Student student = new Student();
            student.setName(studentDao.findStudentById((long) (Math.random() * 10 + 1)).getName());
            student.setMark((int) (Math.random() * 5 + 1));
            studentDao.saveOrUpdate(student);
        }
        studentDao.deleteStudentById(1L);
        studentDao.findAll().forEach(System.out::println);

        sessionFactory.close();
    }

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
