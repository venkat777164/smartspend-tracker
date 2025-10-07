public class Employee implements taxable {
    private int empId;
    private String name;
    private double salary; // This is assumed to be monthly salary

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

 
    public double calctax() {
        // Calculate yearly salary
        double yearlySalary = this.salary * 12;
        // Calculate income tax using the constant from Taxable interface
        return yearlySalary * taxable.incometax;
    }

    // Getters for displaying information (optional, but good practice)
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}