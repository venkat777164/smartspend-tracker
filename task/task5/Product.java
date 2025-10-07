public class Product implements Taxable {
    private String pid;
    private double price;       // Unit price
    private int quantity;

    public Product(String pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate sales tax on unit price of product
    @Override
    public double calcTax() {
        // Calculate sales tax on the unit price
        return this.price * Taxable.salesTax;
    }

    // Getters for displaying information (optional, but good practice)
    public String getPid() {
        return pid;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}