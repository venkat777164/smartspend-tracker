class Product {
    int pid;
    double price;
    int quantity;

    Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }
}

class ProductMain {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Product[] products = new Product[5];

        // a. Accept 5 product info
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter product " + (i + 1) + " PID, Price, Quantity:");
            int pid = sc.nextInt();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            products[i] = new Product(pid, price, quantity);
        }

        // b. Find product with highest price
        double maxPrice = products[0].price;
        int maxPid = products[0].pid;
        for (Product p : products) {
            if (p.price > maxPrice) {
                maxPrice = p.price;
                maxPid = p.pid;
            }
        }
        System.out.println("Product with highest price has PID: " + maxPid);

        // c. Calculate total amount spent
        double total = calculateTotal(products);
        System.out.println("Total amount spent: " + total);
    }

    static double calculateTotal(Product[] products) {
        double sum = 0;
        for (Product p : products) {
            sum += p.price * p.quantity;
        }
        return sum;
    }
}