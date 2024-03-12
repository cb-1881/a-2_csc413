Assignment 2


This project displays the DAO's and DTO's I made for these business objects:

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
        

        