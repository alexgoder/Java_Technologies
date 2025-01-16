package alexgoder.jt;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final EmployeeDAO employeeDAO = new EmployeeDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> searchEmployee();
                case 3 -> deleteEmployee();
                case 4 -> updateEmployee();
                case 5 -> addCourse();
                case 6 -> searchCourseByEmployee();
                case 7 -> listEmployeesByCompany();
                case 8 -> listEmployeesByEmploymentDuration();
                case 9 -> listEmployeesByCourse();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("""
                \nMenu:
                1. Add Employee
                2. Search Employee by Name
                3. Delete Employee
                4. Update Employee
                5. Add Course
                6. Search Courses for an Employee
                7. Display Employees of a Company
                8. Display Employees with Employment Longer Than X Years
                9. Display Employees by Course Name
                0. Exit
                Enter your choice:""");
    }

    private static void addEmployee() {
        Employee employee = new Employee();
        System.out.print("Enter name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Enter firm: ");
        employee.setFirm(scanner.nextLine());
        System.out.print("Enter position: ");
        employee.setPosition(scanner.nextLine());
        System.out.print("Enter date of employment (yyyy-mm-dd): ");
        employee.setDateOfEmployment(LocalDate.parse(scanner.nextLine()));
        employeeDAO.addEmployee(employee);
        System.out.println("Employee added successfully!");
    }

    private static void searchEmployee() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        List<Employee> employees = employeeDAO.searchEmployeeByName(name);
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(e -> System.out.println(e.getId() + " - " + e.getName() + " - " + e.getFirm()));
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        employeeDAO.deleteEmployee(id);
        System.out.println("Employee deleted successfully (if existed).");
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee employee = employeeDAO.searchEmployeeByName("").stream().filter(e -> e.getId() == id).findFirst()
                .orElse(null);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        System.out.print("Enter new name: ");
        employee.setName(scanner.nextLine());
        System.out.print("Enter new firm: ");
        employee.setFirm(scanner.nextLine());
        System.out.print("Enter new position: ");
        employee.setPosition(scanner.nextLine());
        System.out.print("Enter new date of employment (yyyy-mm-dd): ");
        employee.setDateOfEmployment(LocalDate.parse(scanner.nextLine()));
        employeeDAO.updateEmployee(employee);
        System.out.println("Employee updated successfully!");
    }

    private static void addCourse() {
        System.out.print("Enter employee ID: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        Employee employee = employeeDAO.searchEmployeeByName("").stream().filter(e -> e.getId() == employeeId)
                .findFirst().orElse(null);
        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }
        Course course = new Course();
        System.out.print("Enter course name: ");
        course.setName(scanner.nextLine());
        System.out.print("Enter number of hours: ");
        course.setNumberOfHours(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter course value: ");
        course.setValue(Double.parseDouble(scanner.nextLine()));
        System.out.print("Graduation diploma (true/false): ");
        course.setGraduationDiploma(Boolean.parseBoolean(scanner.nextLine()));
        System.out.print("Enter year: ");
        course.setYear(Integer.parseInt(scanner.nextLine()));
        course.setEmployee(employee);
        // Save course using a CourseDAO
        new CourseDAO().addCourse(course);
        System.out.println("Course added successfully!");
    }

    private static void searchCourseByEmployee() {
        System.out.print("Enter employee ID: ");
        int employeeId = Integer.parseInt(scanner.nextLine());
        List<Course> courses = new CourseDAO().searchCoursesByEmployee(employeeId);
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            courses.forEach(c -> System.out.println(c.getIdCourse() + " - " + c.getName()));
        }
    }

    private static void listEmployeesByCompany() {
        System.out.print("Enter company name: ");
        String firm = scanner.nextLine();
        List<Employee> employees = employeeDAO.getEmployeesByCompany(firm);
        employees.forEach(e -> System.out.println(e.getId() + " - " + e.getName()));
    }

    private static void listEmployeesByEmploymentDuration() {
        System.out.print("Enter minimum years of employment: ");
        int years = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = employeeDAO.getEmployeesWithLongEmployment(years);
        employees.forEach(e -> System.out.println(e.getId() + " - " + e.getName() + " - " + e.getFirm()));
    }

    private static void listEmployeesByCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        List<Employee> employees = employeeDAO.getEmployeesByCourseName(courseName);
        employees.forEach(e -> System.out.println(e.getId() + " - " + e.getName()));
    }
}