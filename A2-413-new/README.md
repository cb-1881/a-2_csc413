Assignment 2


This project displays the DAO's and DTO's I made for these business objects:

In computer programming, create, read, update, and delete (CRUD) are the four basic operations of persistent storage.

Flow of the Project:

- Database Setup and Teardown:
        DatabaseSetup and DropTables classes are used for initializing and cleaning up the database schema, respectively.

- Operation Execution:
        CRUD operations are executed through the DAO implementations, invoked by client code or tests, such as in the DAOTestSuite. The                client code demonstrates adding, fetching, updating, and deleting entities.

- Testing:
        DAOTestSuite contains JUnit tests that verify the functionality of CRUD operations on the entities by using DAO implementations.                 These tests ensure that the application's data access layer works as expected.

  - Utilities and Extensions:
    Classes like LinkedList, LinkedPriorityQueue, and their interfaces, while not directly related to the bank management system's core                functionality, indicate an attempt to implement custom data structures for possible use within the system.
    JSONDemo demonstrates serialization and deserialization of Customer objects to and from JSON, indicating an interest in handling data                exchange formats, potentially for APIs or data storage.


Important Note:

The DAOs are the interfaces I implemented and the corresponding Business objects
ie: CustomerDAO.java are actually the DTOs that utilize the sql functions to transfer info.

Issues:
The folder structure is non existant but everything is functional inside of src
Instructions:
        run "make" where the makefile is to see the business objects proof of concept output

        run "make json" for json implementation example

        run "make tests" for examples of junit tests of Teller and Security objects

        FOR SETTING UP DATABASE IN SQL:
    ========================================    
        my database info for testing sql functionality:
            Database name: mydatabase
                Username: bankapp
                Password: password

       

        run "make sqlSetup " to create the sql tables that make this server and tests run properly
        once you run that you can run "make DAOTestSuite" to see the sql tests i wrote in DAOTestSuite.java

        run "make sql " to show connection is properly setup
         
        run "make DropTables" to remove the tables for whatever reason, 
                probably make your life a little easier :]

        Also "make clean to delete all class files"
        

        
