import java.util.Scanner;

public class weekdayarray {
    public static void main(String[] args) {
        String[] weekdays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day index (0-6): ");
        int index = scanner.nextInt();

        try {
            if (index < 0 || index > 6) {
                throw new ArrayIndexOutOfBoundsException("Index out of range! Valid range is 0 to 6.");
            }
            System.out.println("Day: " + weekdays[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}