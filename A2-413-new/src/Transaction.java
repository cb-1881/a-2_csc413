import java.util.Date;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private String transactionType; // e.g., "DEPOSIT", "WITHDRAWAL"
    private double amount;
    private Date timestamp;

    // Constructor
    public Transaction(String transactionId, String accountNumber, String transactionType, double amount, Date timestamp) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    // Additional functionality methods can be added here.
    // Example: processTransaction, validateTransaction, etc.
}
