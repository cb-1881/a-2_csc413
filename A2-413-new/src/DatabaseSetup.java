import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "bankapp";
        String password = "password";

        // SQL statements for table creation
        String[] sqlStatements = {
                "CREATE TABLE accounts (accountNumber VARCHAR(20) PRIMARY KEY, balance DOUBLE, customerId VARCHAR(20))",
                "CREATE TABLE administrators (staffId VARCHAR(20) PRIMARY KEY, name VARCHAR(100))",
                "CREATE TABLE customers (customerId VARCHAR(20) PRIMARY KEY, name VARCHAR(100), accountNumber VARCHAR(20), balance DOUBLE)",
                "CREATE TABLE tellers (tellerId VARCHAR(20) PRIMARY KEY, name VARCHAR(100), branchId VARCHAR(20))",
                "CREATE TABLE securities (securityId VARCHAR(20) PRIMARY KEY, name VARCHAR(100), level VARCHAR(20))",
                "CREATE TABLE transactions (transactionId VARCHAR(20) PRIMARY KEY, accountNumber VARCHAR(20), transactionType VARCHAR(50), amount DOUBLE, timestamp DATETIME)"
        };

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            
            // Execute each SQL statement to create tables
            for (String sql : sqlStatements) {
                stmt.execute(sql);
                System.out.println("Executed: " + sql);
            }
            System.out.println("All tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
