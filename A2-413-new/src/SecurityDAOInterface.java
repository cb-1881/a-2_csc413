import java.util.*;
public interface SecurityDAOInterface {
    void addSecurity(Security security);
    Security getSecurity(String securityId);
    void updateSecurity(Security security);
    void deleteSecurity(String securityId);
    List<Security> getAllSecurities();
}
