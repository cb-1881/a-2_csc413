public class Customer {
  private String customerId;
  private String name;
  private String accountNumber;
  private double balance;

  // Constructor
  public Customer(String customerId, String name, String accountNumber, double balance) {
    this.customerId = customerId;
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  // Getters and Setters
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
  // toString method
  @Override
  public String toString() {
      return " Customer  {" +
              "customerId='" + customerId + '\'' +
              ", name='" + name + '\'' +
              ", accountNumber='" + accountNumber + '\'' +
              ", balance=" + balance +
              '}' + "\n" ;
  }


  // Additional methods to manipulate the account
}
