import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TellerDAO implements TellerDAOInterface {
    private Connection getConnection() throws SQLException {
        // Replace these with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "bankapp";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }


    @Override
    public void addTeller(Teller teller) {
        String sql = "INSERT INTO tellers (tellerId, name, branchId) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, teller.getTellerId());
            pstmt.setString(2, teller.getName());
            pstmt.setString(3, teller.getBranchId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Teller getTeller(String tellerId) {
        String sql = "SELECT * FROM tellers WHERE tellerId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tellerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Teller(
                        rs.getString("tellerId"),
                        rs.getString("name"),
                        rs.getString("branchId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateTeller(Teller teller) {
        String sql = "UPDATE tellers SET name = ?, branchId = ? WHERE tellerId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, teller.getName());
            pstmt.setString(2, teller.getBranchId());
            pstmt.setString(3, teller.getTellerId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeller(String tellerId) {
        String sql = "DELETE FROM tellers WHERE tellerId = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tellerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Teller> getAllTellers() {
        List<Teller> tellers = new ArrayList<>();
        String sql = "SELECT * FROM tellers";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tellers.add(new Teller(
                        rs.getString("tellerId"),
                        rs.getString("name"),
                        rs.getString("branchId")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tellers;
    }
}
