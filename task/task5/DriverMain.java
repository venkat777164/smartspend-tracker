import java.util.Scanner;

public class DriverMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Accept Employee Information ---
        System.out.println("--- Enter Employee Details ---");
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();

        System.out.print("Enter Employee Monthly Salary: ");
        double empSalary = scanner.nextDouble();

        // Create Employee object
        Employee employee = new Employee(empId, empName, empSalary);

        // --- Accept Product Information ---
        System.out.println("\n--- Enter Product Details ---");
        System.out.print("Enter Product ID: ");
        scanner.nextLine(); // Consume newline again
        String prodId = scanner.nextLine();

        System.out.print("Enter Product Unit Price: ");
        double prodPrice = scanner.nextDouble();

        System.out.print("Enter Product Quantity: ");
        int prodQuantity = scanner.nextInt();

        // Create Product object
        Product product = new Product(prodId, prodPrice, prodQuantity);

        // --- Print Tax Information ---
        System.out.println("\n--- Tax Calculation Results ---");

        // Calculate and print Income Tax for Employee
        double employeeIncomeTax = employee.calcTax();
        System.out.println("Employee: " + employee.getName() + " (ID: " + employee.getEmpId() + ")");
        System.out.println("Yearly Income Tax: $" + String.format("%.2f", employeeIncomeTax));

        // Calculate and print Sales Tax for Product (on unit price)
        double productSalesTax = product.calcTax();
        System.out.println("\nProduct: " + product.getPid() + " (Unit Price: $" + String.format("%.2f", product.getPrice()) + ")");
        System.out.println("Sales Tax per Unit: $" + String.format("%.2f", productSalesTax));

        scanner.close();
    }
}