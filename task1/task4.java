import java.util.Scanner;
class task {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = scan.nextInt();
        System.out.print("Enter second number: ");
        int b = scan.nextInt();
        System.out.print("Enter third number: ");
        int c = scan.nextInt();
        int smallest;
        if (a <= b && a <= c) {
            smallest = a;
        } else if (b <= a && b <= c) {
            smallest = b;
        } else {
            smallest = c;
        }
        System.out.println("The smallest number is: " + smallest);
    }
}
