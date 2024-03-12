import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements TransactionDAOInterface {

    private Connection getConnection() throws SQLException {
        // Replace these with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "bankapp";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }


    @Override
    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (transactionId, accountNumber, transactionType, amount, timestamp) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transaction.getTransactionId());
            pstmt.setString(2, transaction.getAccountNumber());
            pstmt.setString(3, transaction.getTransactionType());
            pstmt.setDouble(4, transaction.getAmount());
            pstmt.setTimestamp(5, new Timestamp(transaction.getTimestamp().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Transaction getTransaction(String transactionId) {
        String sql = "SELECT * FROM transactions WHERE transactionId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transactionId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Transaction(
                        rs.getString("transactionId"),
                        rs.getString("accountNumber"),
                        rs.getString("transactionType"),
                        rs.getDouble("amount"),
                        new java.util.Date(rs.getTimestamp("timestamp").getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE transactions SET accountNumber = ?, transactionType = ?, amount = ?, timestamp = ? WHERE transactionId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transaction.getAccountNumber());
            pstmt.setString(2, transaction.getTransactionType());
            pstmt.setDouble(3, transaction.getAmount());
            pstmt.setTimestamp(4, new Timestamp(transaction.getTimestamp().getTime()));
            pstmt.setString(5, transaction.getTransactionId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransaction(String transactionId) {
        String sql = "DELETE FROM transactions WHERE transactionId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transactionId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                transactions.add(new Transaction(
                        rs.getString("transactionId"),
                        rs.getString("accountNumber"),
                        rs.getString("transactionType"),
                        rs.getDouble("amount"),
                        new java.util.Date(rs.getTimestamp("timestamp").getTime())));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
