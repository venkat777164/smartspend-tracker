class Person {
    String name;
    int age;

    // Default constructor with default age
    Person(String name) {
        this.name = name;
        this.age = 18;
    }

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}