public class Account {
    private String accountNumber;
    private double balance;
    private String customerId;

    // Constructor
    public Account(String accountNumber, double balance, String customerId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerId = customerId;
    }

    // Getters
    public String getAccountNumber() {
                return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    // Setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    // Additional functionality methods can be added here.
    // Example: deposit, withdraw, etc.
}
 
    

