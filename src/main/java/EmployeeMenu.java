import java.util.Scanner;

public class EmployeeMenu {
    HandleEmployee handleEmployee;


    Scanner scanner = new Scanner(System.in);

    public EmployeeMenu(HandleEmployee handleEmployee) {
        this.handleEmployee = handleEmployee;
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("Welcome to Employee Menu");
            System.out.println("Pick an option to handle employees");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleEmployee.addEmployee();
                    break;
                case 2:
                    Employee selectedEmployee = handleEmployee.searchEmployee(scanner.nextLine());
                    if (selectedEmployee != null) {
                        showEmployeeMenu(selectedEmployee); // Pass the selected employee to the menu
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    // Show menu for selected employee
    private void showEmployeeMenu(Employee employee) {
        while (true) {
            System.out.println("Selected Employee: " + employee.getName());
            System.out.println("1. Edit Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. View Details");
            System.out.println("4. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleEmployee.editEmployee(employee);
                    break;
                case 2:
                    handleEmployee.deleteEmployee(employee);
                    return; // Exit the menu after deletion
                case 3:
                    System.out.println(employee); // Display employee details
                    break;
                case 4:
                    return; // Exit to main menu
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
