public interface taxable {
    // Member constants for tax rates
    double salestax = 0.07;   // 7%
    double incometax = 0.105; // 10.5%

    // Abstract method to calculate tax
    double calctax();
}