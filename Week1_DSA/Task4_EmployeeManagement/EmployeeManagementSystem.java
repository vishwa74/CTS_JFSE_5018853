class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    private int capacity;

    public EmployeeManagementSystem(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    // Add employee
    public void addEmployee(Employee employee) {
        if (size == capacity) {
            System.out.println("Array is full, can't add more employees.");
            return;
        }
        employees[size++] = employee;
    }

    // Search employee by employeeId
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by employeeId
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                employees[i] = employees[size - 1]; // Replace with the last employee
                employees[size - 1] = null; // Remove the last employee
                size--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);
        ems.addEmployee(new Employee(1, "John Doe", "Developer", 60000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Manager", 80000));

        System.out.println("Traverse employees:");
        ems.traverseEmployees();

        System.out.println("Search employee with ID 1:");
        System.out.println(ems.searchEmployee(1));

        System.out.println("Delete employee with ID 1:");
        ems.deleteEmployee(1);

        System.out.println("Traverse employees after deletion:");
        ems.traverseEmployees();
    }
}
