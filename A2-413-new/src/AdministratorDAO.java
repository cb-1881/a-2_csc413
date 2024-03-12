import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDAO implements AdministratorDAOInterface {
    private Connection getConnection() throws SQLException {
        // Replace these with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "bankapp";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }

    
    @Override
    public void addAdministrator(Administrator administrator) {
        String sql = "INSERT INTO administrators (staffId, name) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, administrator.getStaffId());
            pstmt.setString(2, administrator.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Administrator getAdministrator(String staffId) {
        String sql = "SELECT * FROM administrators WHERE staffId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Administrator(
                        rs.getString("staffId"),
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAdministrator(Administrator administrator) {
        String sql = "UPDATE administrators SET name = ? WHERE staffId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, administrator.getName());
            pstmt.setString(2, administrator.getStaffId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAdministrator(String staffId) {
        String sql = "DELETE FROM administrators WHERE staffId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        List<Administrator> administrators = new ArrayList<>();
        String sql = "SELECT * FROM administrators";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                administrators.add(new Administrator(
                        rs.getString("staffId"),
                        rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return administrators;
    }
}
