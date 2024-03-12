import java.util.*;

public interface TellerDAOInterface {
    void addTeller(Teller teller);
    Teller getTeller(String tellerId);
    void updateTeller(Teller teller);
    void deleteTeller(String tellerId);
    List<Teller> getAllTellers();
}

