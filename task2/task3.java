import java.util.Arrays;
import java.util.List;
class task{
    public static void main(String[] args) {
        List<String> students = Arrays.asList("Alice", "Bob", "Anu", "Charlie", "Amit", "David", "Arun", "Eve", "Anjali", "Frank");
        
        System.out.println("Students whose names start with 'A':");
        students.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }
}