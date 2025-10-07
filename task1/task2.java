import java.util.Scanner;
class task{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = scan.nextInt();

        if (num >= 0) {
            System.out.println("positive");
        } else {
            System.out.println(num); 
        }

    }
}
