class Account {
    double balance;

    // No-arg constructor
    Account() {
        balance = 0;
    }

    // Parameterized constructor
    Account(double amount) {
        balance = amount;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}