import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.*;


public class HandleEmployeeTest {
    HandleEmployee handleEmployee;

    @BeforeEach
    public void setup() {
        handleEmployee = new HandleEmployee();
        Employee employee = new Employee("john Doe", "Software developer", 30, "Man",
                3000, LocalDate.now());
        handleEmployee.employees.add(employee);
    }

    @Test
    void testAddEmployee() {
        assertEquals(1, handleEmployee.employees.size());
        assertEquals("john Doe", handleEmployee.employees.getFirst().getName());
        assertEquals("Software developer", handleEmployee.employees.getFirst().getJobTitle());
        assertEquals(3000, handleEmployee.employees.getFirst().getSalary());
    }

    @Test
    void testRemoveEmployee() {
        handleEmployee.deleteEmployee(handleEmployee.employees.getFirst());
        assertEquals(0, handleEmployee.employees.size());
    }

    @Test
    void testEditEmployee() {
        Employee employee = new Employee("john Doe", "Software developer", 30, "Man",
                3000, LocalDate.now());
        handleEmployee.employees.add(employee);

        employee.setName("Jane Doe");
        employee.setJobTitle("Software Engineer");
        employee.setSalary(4000);
        employee.setAge(25);

        assertEquals("Jane Doe", employee.getName());
        assertEquals("Software Engineer", employee.getJobTitle());
        assertEquals(4000, employee.getSalary());
        assertEquals(25, employee.getAge());
    }



    @Test
    public void testSearchEmployee() {
        handleEmployee.employees.clear();
        Employee emp1 = new Employee("Mike Johnson", "DevOps Engineer", 34, "Male",
                80000, LocalDate.now());
        Employee emp2 = new Employee("Sarah Lee", "QA Tester", 29, "Female",
                50000, LocalDate.now());
        handleEmployee.employees.add(emp1);
        handleEmployee.employees.add(emp2);

        String searchName = "Sarah";
        Employee foundEmployee = handleEmployee.searchEmployee(searchName);

        assertNotNull(foundEmployee);
        assertEquals("Sarah Lee", foundEmployee.getName());


    }






}