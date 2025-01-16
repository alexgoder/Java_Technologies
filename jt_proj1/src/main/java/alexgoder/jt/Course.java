package alexgoder.jt;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCourse;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int numberOfHours;

    private double value;

    @Column(nullable = false)
    private boolean graduationDiploma;

    private int year;

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isGraduationDiploma() {
        return graduationDiploma;
    }

    public void setGraduationDiploma(boolean graduationDiploma) {
        this.graduationDiploma = graduationDiploma;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}