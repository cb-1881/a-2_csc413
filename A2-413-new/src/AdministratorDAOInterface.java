import java.util.*;

public interface AdministratorDAOInterface {
    void addAdministrator(Administrator administrator);
    Administrator getAdministrator(String staffId);
    void updateAdministrator(Administrator administrator);
    void deleteAdministrator(String staffId);
    List<Administrator> getAllAdministrators();
}


