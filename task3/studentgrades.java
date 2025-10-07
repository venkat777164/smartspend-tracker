import java.util.HashMap;
import java.util.Scanner;

public class studentgrades {
    private HashMap<String, Integer> studentMap;

    public studentgrades() {
        studentMap = new HashMap<>();
    }

    public void addStudent(String name, int grade) {
        studentMap.put(name, grade);
        System.out.println("Student added successfully.");
    }

    public void displayGrade(String name) {
        if (studentMap.containsKey(name)) {
            System.out.println("Grade of " + name + " is: " + studentMap.get(name));
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        studentgrades sg = new studentgrades();
        Scanner sc = new Scanner(System.in);

        sg.addStudent("Alice", 85);
        sg.addStudent("Bob", 92);

        System.out.print("Enter student name to search: ");
        String name = sc.nextLine();
        sg.displayGrade(name);
    }
}