//package jsondemo;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Iterator;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.json.stream.*;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.Json;


/*
 * Modified to work with Customer objects instead of Employee objects
 */
public class JSONDemo {

    static ObjectMapper objectMapper = null;

    // Sample JSON strings adjusted for Customer attributes
    static String jsonCustomerString = "{ \"customerId\" : \"C001\", \"name\" : \"John Doe\", \"accountNumber\" : \"123456789\", \"balance\" : 1000.00 }";
    static String jsonCustomersString = "[{ \"customerId\" : \"C002\", \"name\" : \"Jane Doe\", \"accountNumber\" : \"987654321\", \"balance\" : 1500.00 }, { \"customerId\" : \"C003\", \"name\" : \"Jim Beam\", \"accountNumber\" : \"192837465\", \"balance\" : 2000.00 }]";

    public static void main(String[] args) {

        objectMapper = new ObjectMapper();
        
        System.out.println("\nCreating Customer object");
        
        // Create Customer object
        Customer customer = new Customer("C004", "Paul Newman", "123123123", 2500.00);
        String customerString = ""; 
        
        // Create string version of the customer object
        try {
            customerString = objectMapper.writeValueAsString(customer);
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }
        
        System.out.println("\nJSON String version of Customer object\n" + customerString);
        
        // Read in customer strings as json tree
        try {
            JsonNode jsonNode1 = objectMapper.readTree(jsonCustomerString);
            JsonNode jsonNode2 = objectMapper.readTree(jsonCustomersString);

            // Printing single Customer detail
            System.out.println("\nSingle Customer Detail JSON String:");
            System.out.println(jsonNode1.toPrettyString());

            // Printing multiple Customer details
            System.out.println("\nMultiple Customer Detail JSON String:");
            System.out.println(jsonNode2.toPrettyString());
            
            System.out.println("\nNow printing each customer detail: ");
            Iterator<JsonNode> it = jsonNode2.elements();
            while(it.hasNext()) {
                JsonNode jNode = it.next();
                System.out.println("\nCustomerId: " + jNode.get("customerId").asText());
                System.out.println("Name: " + jNode.get("name").asText());
                System.out.println("AccountNumber: " + jNode.get("accountNumber").asText());
                System.out.println("Balance: " + jNode.get("balance").asDouble());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Working with Customer Objects (methods to be implemented similar to Employee example)
        readJsonCustomer();
        readJsonCustomers();
    }
    
    public static void readJsonCustomer() {
        Customer customerObj = null;
    
        try {
            // Deserialize JSON string to Customer object
            customerObj = objectMapper.readValue(jsonCustomerString, Customer.class);
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }
    
        // Display data from the Customer object created from the JSON String
        System.out.println("\nReading data from JSON String of single customer:");
        if (customerObj != null) {
            System.out.println("CustomerId: " + customerObj.getCustomerId());
            System.out.println("Name: " + customerObj.getName());
            System.out.println("AccountNumber: " + customerObj.getAccountNumber());
            System.out.println("Balance: " + customerObj.getBalance());
        }
    }
    
    public static void readJsonCustomers() {
        List<Customer> customerList = null;
    
        try {
            // Deserialize JSON string to a list of Customer objects
            customerList = objectMapper.readValue(jsonCustomersString, new TypeReference<List<Customer>>(){});
        } catch (JsonProcessingException jpe) {
            System.out.println(jpe.getMessage());
        }
    
        System.out.println("\nReading data from JSON array of multiple customers:");
    
        if (customerList != null) {
            for (Customer customer : customerList) {
                System.out.println("CustomerId: " + customer.getCustomerId());
                System.out.println("Name: " + customer.getName());
                System.out.println("AccountNumber: " + customer.getAccountNumber());
                System.out.println("Balance: " + customer.getBalance() + "\n");
            }
        }
    }
    
}
