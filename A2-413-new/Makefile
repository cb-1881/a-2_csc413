# Makefile

# Define variables for directories and classpath
JUNIT_JAR := dep/junit-4.12.jar
HAMCREST_JAR := dep/hamcrest-core-1.3.jar
SQL_JAR := dep/mysql-connector-j-8.3.0.jar
JAVAX_JAR:= dep/javax.json-api-1.1.4.jar
JACKSONCORE_JAR:= dep/jackson-core-2.16.1.jar
JACKSONDATABIND_JAR:= dep/jackson-databind-2.16.1.jar
JACKSONANNOTATIONS_JAR := dep/jackson-annotations-2.16.1.jar
CLASSPATH := $(JUNIT_JAR):$(HAMCREST_JAR):$(SQL_JAR):$(JAVAX_JAR):$(JACKSONCORE_JAR):$(JACKSONDATABIND_JAR):$(JACKSONANNOTATIONS_JAR):src
SRC_DIR := src
TEST_CLASS := ListTest
SQL_class := test_sql
JSON_class:= JSONDemo
QueueTest_class := PriorQueueTest
TellerTest_class := TellerTest
SecurityTest_class := SecurityTest
# Default target
all: compile run

# Compile Java files
compile:
	javac -cp $(CLASSPATH) $(SRC_DIR)/*.java

# Run the test class
run:
	java -cp $(CLASSPATH) $(QueueTest_class)

tests:
	javac -cp dep/junit-4.12.jar:dep/hamcrest-core-1.3.jar: src/Teller.java src/TellerTest.java src/Security.java src/SecurityTest.java
	java -cp dep/junit-4.12.jar:dep/hamcrest-core-1.3.jar:dep/mysql-connector-j-8.3.0.jar:dep/javax.json-api-1.1.4.jar:dep/jackson-core-2.16.1.jar:dep/jackson-databind-2.16.1.jar:dep/jackson-annotations-2.16.1.jar:src TellerTest
 
DropTables:
	java -cp dep/junit-4.12.jar:dep/hamcrest-core-1.3.jar:dep/mysql-connector-j-8.3.0.jar:dep/javax.json-api-1.1.4.jar:dep/jackson-core-2.16.1.jar:dep/jackson-databind-2.16.1.jar:dep/jackson-annotations-2.16.1.jar:src DropTables
sqlSetup:
	java -cp dep/junit-4.12.jar:dep/hamcrest-core-1.3.jar:dep/mysql-connector-j-8.3.0.jar:dep/javax.json-api-1.1.4.jar:dep/jackson-core-2.16.1.jar:dep/jackson-databind-2.16.1.jar:dep/jackson-annotations-2.16.1.jar:src DatabaseSetup


sql:
	java -cp $(CLASSPATH) $(SQL_class)

# Run JSONDemo class
json:
	java -cp $(CLASSPATH) $(JSON_class)

# Run que test class
queue:
	java -cp $(CLASSPATH) $(QueueTest_class)
# Clean the class files
clean:
	rm -rf src/*.class

.PHONY: all compile run clean
