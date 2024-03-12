import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SecurityDAO implements SecurityDAOInterface {
    private Connection getConnection() throws SQLException {
        // Replace these with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "bankapp";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addSecurity(Security security) {
        String sql = "INSERT INTO securities (securityId, name, level) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, security.getSecurityId());
            pstmt.setString(2, security.getName());
            pstmt.setString(3, security.getLevel());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Security getSecurity(String securityId) {
        String sql = "SELECT * FROM securities WHERE securityId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, securityId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Security(
                        rs.getString("securityId"),
                        rs.getString("name"),
                        rs.getString("level"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateSecurity(Security security) {
        String sql = "UPDATE securities SET name = ?, level = ? WHERE securityId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, security.getName());
            pstmt.setString(2, security.getLevel());
            pstmt.setString(3, security.getSecurityId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSecurity(String securityId) {
        String sql = "DELETE FROM securities WHERE securityId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, securityId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Security> getAllSecurities() {
        List<Security> securities = new ArrayList<>();
        String sql = "SELECT * FROM securities";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                securities.add(new Security(
                        rs.getString("securityId"),
                        rs.getString("name"),
                        rs.getString("level")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return securities;
    }
}

