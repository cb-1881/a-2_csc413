import java.util.List;


public interface AccountDAOInterface {
    void addAccount(Account account);
    Account getAccount(String accountNumber);
    void updateAccount(Account account);
    void deleteAccount(String accountNumber);
    List<Account> getAllAccounts();
}