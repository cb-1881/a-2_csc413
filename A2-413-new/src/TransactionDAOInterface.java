import java.util.*;

public interface TransactionDAOInterface {
    void addTransaction(Transaction transaction);
    Transaction getTransaction(String transactionId);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(String transactionId);
    List<Transaction> getAllTransactions();
}
