package alexgoder.jt;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CourseDAO {
    public void addCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        }
    }

    public List<Course> searchCoursesByEmployee(int employeeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Course WHERE employee.id = :employeeId", Course.class)
                    .setParameter("employeeId", employeeId)
                    .list();
        }
    }

    public void updateCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(course);
            transaction.commit();
        }
    }

    public void deleteCourse(int courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                session.delete(course);
            }
            transaction.commit();
        }
    }
}