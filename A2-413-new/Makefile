# Makefile

# Define variables for directories and classpath
JUNIT_JAR := dep/junit-4.12.jar
HAMCREST_JAR := dep/hamcrest-core-1.3.jar
SQL_JAR := dep/mysql-connector-j-8.3.0.jar
CLASSPATH := $(JUNIT_JAR):$(HAMCREST_JAR):$(SQL_JAR):./src
SRC_DIR := src
TEST_CLASS := ListTest
SQL_class := test_sql
# Default target
all: compile run

# Compile Java files
compile:
	javac -cp $(CLASSPATH) $(SRC_DIR)/*.java

# Run the test class
run:
	java -cp $(CLASSPATH) $(TEST_CLASS)

sql:
	java -cp $(CLASSPATH) $(SQL_class)

# Clean the class files
clean:
	rm -rf src/*.class

.PHONY: all compile run clean
