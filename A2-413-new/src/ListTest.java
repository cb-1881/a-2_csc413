//import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import javax.json.stream.*;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.Json;

public class ListTest {

  @Test
  public void testCustomerList() {
    LinkedList<Customer> customerList = new LinkedList<>();
    Customer alice = new Customer("1", "Alice", "5678", 2000.0);
    Customer bob = new Customer("2", "Bob", "9012", 1500.0);
    Customer carol = new Customer("3", "Carol", "3456", 1800.0);
//lifo for linked list
    customerList.add(carol);
    customerList.add(bob);
    customerList.add(alice);
    Assert.assertEquals(alice, customerList.get(0));
    Assert.assertEquals(bob, customerList.get(1));
    Assert.assertEquals(carol, customerList.get(2));
  
  }

  public static void main(String[] args) {
    // Run the test
    org.junit.runner.JUnitCore.main("ListTest");
    testPrint();
    /* 
    LinkedList<Customer> testtestcustomerList = new LinkedList<>();
    Customer alice = new Customer("1", "Alice", "5678", 2000.0);
    Customer bob = new Customer("2", "Bob", "9012", 1500.0);
    Customer carol = new Customer("3", "Carol", "3456", 1800.0);
    testtestcustomerList.add(carol);
    testtestcustomerList.add(bob);
    testtestcustomerList.printList();
    */
  }

  public static void testPrint(){

    LinkedList<Customer> testtestcustomerList = new LinkedList<>();
    Customer alice = new Customer("1", "Alice", "5678", 2000.0);
    Customer bob = new Customer("2", "Bob", "9012", 1500.0);
    Customer carol = new Customer("3", "Carol", "3456", 1800.0);
    testtestcustomerList.add(carol);
    testtestcustomerList.add(bob);
    testtestcustomerList.printList();

    LinkedList<Administrator> admintest = new LinkedList<>();
    Administrator dave = new Administrator("913456", "dave");
    admintest.add(dave);
    admintest.printList();
      
//    );

  }
}
