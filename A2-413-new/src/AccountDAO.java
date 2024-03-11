import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements AccountDAOInterface {

    private String jdbcURL = "jdbc:mysql://localhost:3306/mydatabase";
    private String jdbcUsername = "bankapp";
    private String jdbcPassword = "password";

    private static final String INSERT_ACCOUNTS_SQL = "INSERT INTO accounts (accountNumber, balance, customerId) VALUES (?, ?, ?);";
    private static final String SELECT_ACCOUNT_BY_ID = "SELECT accountNumber, balance, customerId FROM accounts WHERE accountNumber =?";
    private static final String SELECT_ALL_ACCOUNTS = "SELECT * FROM accounts";
    private static final String DELETE_ACCOUNTS_SQL = "DELETE FROM accounts WHERE accountNumber = ?;";
    private static final String UPDATE_ACCOUNTS_SQL = "UPDATE accounts SET balance = ?, customerId = ? WHERE accountNumber = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // Handle SQL exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Handle class not found exception
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void addAccount(Account account) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNTS_SQL)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setDouble(2, account.getBalance());
            preparedStatement.setString(3, account.getCustomerId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccount(String accountNumber) {
        Account account = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID)) {
            preparedStatement.setString(1, accountNumber);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String accNumber = rs.getString("accountNumber");
                double balance = rs.getDouble("balance");
                String customerId = rs.getString("customerId");
                account = new Account(accNumber, balance, customerId);
            }
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNTS_SQL)) {
            statement.setDouble(1, account.getBalance());
            statement.setString(2, account.getCustomerId());
            statement.setString(3, account.getAccountNumber());
            statement.executeUpdate();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(String accountNumber) {
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_ACCOUNTS_SQL)) {
            statement.setString(1, accountNumber);
            statement.executeUpdate();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNTS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String accountNumber = rs.getString("accountNumber");
                double balance = rs.getDouble("balance");
                String customerId = rs.getString("customerId");
                accounts.add(new Account(accountNumber, balance, customerId));
            }
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        }
        return accounts;
    }
}
