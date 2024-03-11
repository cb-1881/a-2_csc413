import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class test_sql {
    public static void main(String[] args) {
        testConnection();
        showDatabaseContents();
    }

    public static void showDatabaseContents() {
        // Connection URL syntax: "jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]"
        String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase?user=bankapp&password=password";
        //"jdbc:mysql://localhost:3306/mydatabase?user=bankapp&password=password";
        // SQL query to retrieve data
        String SQL = "SELECT * FROM Employee";
        
        // Try-with-resources to ensure closing resources
        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            System.out.println("ID | Name | Position");
            while (rs.next()) {
                // Assuming columns are id (int), name (String), position (String)
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("position"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testConnection(){
// Database URL, username and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "bankapp";
        String password = "password";

        // Load and register the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
            return;
        }

        // Attempt to connect to the database
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
