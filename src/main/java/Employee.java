import java.time.LocalDate;
import java.util.Date;

public class Employee {
    //Employee attributes
    private String name;
    private String jobTitle;
    private int age;
    private String gender;
    private int salary;
    private LocalDate seniority;

    //Requested parameters to make employee
    public Employee(String name, String jobTitle, int age, String gender, int salary, LocalDate seniority) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.seniority = seniority;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getSeniority() {
        return seniority;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSeniority(LocalDate seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Job Title: " + jobTitle + ", Age: " + age +
                ", Gender: " + gender + ", Salary: " + salary + ", Seniority: " + seniority;
    }
}
