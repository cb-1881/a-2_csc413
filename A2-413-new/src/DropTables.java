import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTables {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "bankapp";
        String password = "password";

        // SQL statements to drop tables
        String[] sqlStatements = {
            "DROP TABLE IF EXISTS transactions",
            "DROP TABLE IF EXISTS securities",
            "DROP TABLE IF EXISTS tellers",
            "DROP TABLE IF EXISTS customers",
            "DROP TABLE IF EXISTS administrators",
            "DROP TABLE IF EXISTS accounts"
        };

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            
            // Execute each SQL statement to drop tables
            for (String sql : sqlStatements) {
                stmt.execute(sql);
                System.out.println("Dropped table with command: " + sql);
            }
            System.out.println("All specified tables dropped successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
