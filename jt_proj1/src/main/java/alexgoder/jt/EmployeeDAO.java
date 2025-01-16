package alexgoder.jt;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    public List<Employee> searchEmployeeByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee WHERE name = :name", Employee.class)
                    .setParameter("name", name)
                    .list();
        }
    }

    public void updateEmployee(Employee employee) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    public void deleteEmployee(int employeeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        }
    }

    public List<Employee> getEmployeesByCompany(String firm) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee WHERE firm = :firm", Employee.class)
                    .setParameter("firm", firm)
                    .list();
        }
    }

    public List<Employee> getEmployeesWithLongEmployment(int years) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("FROM Employee WHERE YEAR(CURRENT_DATE) - YEAR(dateOfEmployment) > :years",
                            Employee.class)
                    .setParameter("years", years)
                    .list();
        }
    }

    public List<Employee> getEmployeesByCourseName(String courseName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("SELECT e FROM Employee e JOIN e.courses c WHERE c.name = :courseName", Employee.class)
                    .setParameter("courseName", courseName)
                    .list();
        }
    }
}