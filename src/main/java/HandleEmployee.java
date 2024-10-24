import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class HandleEmployee {
    //Employee call
    Employee emp;

    //Scanner for input
    Scanner input = new Scanner(System.in);

    //Date formatter for seniority calculation
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //Employee List
    ArrayList<Employee> employees = new ArrayList<>();

    //Add employee to list
    public void addEmployee() {
        Employee employee = new Employee("", "", 0, "", 0, LocalDate.now());

        System.out.println("Please enter the employee name: ");
        employee.setName(input.nextLine());

        System.out.println("Please enter the employee age: ");
        employee.setAge(input.nextInt());
        input.nextLine();

        System.out.println("Please enter the employee salary: ");
        employee.setSalary(input.nextInt());
        input.nextLine();

        System.out.println("Please enter the employee job title: ");
        employee.setJobTitle(input.nextLine());

        System.out.println("Please enter the employee gender: ");
        employee.setGender(input.nextLine());

        // Default to current date for seniority
        employee.setSeniority(LocalDate.now());

        employees.add(employee);
        System.out.println(employee.getName() + " has been added.");
    }

    //Delete employee from list
    public void deleteEmployee(Employee emp) {
        employees.remove(emp);
        System.out.println(emp.getName() + " has been deleted");
    }

    //Edit employee
    public void editEmployee(Employee emp) {
        System.out.println("Editing Employee: " + emp.getName());

        // Use the utility method to update each field
        emp.setName(updateFieldString(emp.getName(), "name"));
        emp.setAge(updateField(emp.getAge(), "age"));
        emp.setSalary(updateField(emp.getSalary(), "salary"));
        emp.setJobTitle(updateFieldString(emp.getJobTitle(), "job title"));
        emp.setGender(updateFieldString(emp.getGender(), "gender"));



        System.out.println(emp.getName() + " has been updated.");
    }

    public Employee searchEmployee(String search) {
        ArrayList<Employee> searchedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().toLowerCase().contains(search.toLowerCase())) {
                searchedEmployees.add(employee);
                System.out.println((searchedEmployees.size() -1) + ": " + employee);
            }
        }
        if (searchedEmployees.isEmpty()) {
            System.out.println("No matches found");
            return null;
        } else if (searchedEmployees.size() == 1) {
            return searchedEmployees.getFirst();
        } else {
            System.out.println("Select employee");
            int selectedIndex = input.nextInt();
            input.nextLine();

            if (selectedIndex >= 0 && selectedIndex < searchedEmployees.size()) {
                return searchedEmployees.get(selectedIndex);
            } else System.out.println("No matches found");
            return null;
        }
    }

    //Method to make empty String fields keep old value
    private String updateFieldString (String oldValue, String fieldName) {
        System.out.println("Enter new " + fieldName + " :");
        String inputValue = input.nextLine();
        if (!inputValue.trim().isEmpty()) {
            return inputValue;
        }
        return oldValue;
    }

    //Method to make empty Int fields keep old value
    private int updateField(int oldValue, String fieldName) {
        System.out.println("Enter new " + fieldName + " (leave blank to keep current: " + oldValue + "): ");
        String inputValue = input.nextLine();
        if (!inputValue.trim().isEmpty()) {
            return Integer.parseInt(inputValue);
        }
        return oldValue;
    }
}
