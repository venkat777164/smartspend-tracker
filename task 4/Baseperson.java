class BasePerson {
    String name;
    int age;

    BasePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Employee extends BasePerson {
    int employeeId;
    double salary;

    Employee(String name, int age, int employeeId, double salary) {
        super(name, age); // Calling base class constructor
        this.employeeId = employeeId;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
    }
}