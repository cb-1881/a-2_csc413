import java.util.*;

public interface CustomerDAOInterface {
    void addCustomer(Customer customer);
    Customer getCustomer(String customerId);
    void updateCustomer(Customer customer);
    void deleteCustomer(String customerId);
    List<Customer> getAllCustomers();
}

