import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
class task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birthdate (yyyy-mm-dd): ");
        String input = scanner.nextLine();

        LocalDate birthDate = LocalDate.parse(input);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate, currentDate);
        System.out.println("Your age is: " + age.getYears() + " years");
        
    }
}