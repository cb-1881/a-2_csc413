import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAOTestSuite {
    // Assuming we have a way to reset the database to a known state before each test

    private AccountDAO accountDAO;
    private AdministratorDAO administratorDAO;
    private CustomerDAO customerDAO;
    private SecurityDAO securityDAO;
    private TellerDAO tellerDAO;
    private TransactionDAO transactionDAO;

    @Before
    public void setUp() {
        // Initialize DAOs
        accountDAO = new AccountDAO();
        administratorDAO = new AdministratorDAO();
        customerDAO = new CustomerDAO();
        securityDAO = new SecurityDAO();
        tellerDAO = new TellerDAO();
        transactionDAO = new TransactionDAO();
    }

    @Test
    public void testAddAndGetAccount() {
        Account account = new Account("12345", 1000.00, "C001");
        accountDAO.addAccount(account);
        Account fetched = accountDAO.getAccount("12345");
        assertEquals("Balance does not match", 1000.00, fetched.getBalance(), 0.01);
        assertEquals("Customer ID does not match", "C001", fetched.getCustomerId());
    }

    // Similar tests for update, delete, getAll for AccountDAO

    @Test
    public void testAddAndGetAdministrator() {
        Administrator admin = new Administrator("A001", "Admin Name");
        administratorDAO.addAdministrator(admin);
        Administrator fetched = administratorDAO.getAdministrator("A001");
        assertEquals("Admin name does not match", "Admin Name", fetched.getName());
    }

    // Similar tests for CustomerDAO, SecurityDAO, TellerDAO, and TransactionDAO

    // Example test for CustomerDAO
    @Test
    public void testAddAndGetCustomer() {
        Customer customer = new Customer("C002", "Customer Name", "123456789", 2000.00);
        customerDAO.addCustomer(customer);
        Customer fetched = customerDAO.getCustomer("C002");
        assertEquals("Customer name does not match", "Customer Name", fetched.getName());
        assertEquals("Account number does not match", "123456789", fetched.getAccountNumber());
    }

    // Continue with similar tests for update, delete, getAll for each DAO

    public static void main(String[] args){

        org.junit.runner.JUnitCore.main("DAOTestSuite");

    }
}
