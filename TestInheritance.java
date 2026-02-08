class Person {  // Base class
    String name;  // Instance variable

    Person(String n) { // Constructor
        name = n; // Initialize Instance ariable
    }
}

class Student extends Person { // Sub Class
    int rollNo; // Instance variable

    Student(String n, int r) { // Constructor
        super(n); // Call the constructor of the base class
        rollNo = r; // Initialize instance variable
    }

    void display() { // Method to display values
        System.out.println(name + " " + rollNo); // Accessing base class variable
    }
}

public class TestInheritance {  // Main class
    public static void main(String[] args) { // Main Method
        Student s = new Student("SURYA", 49); // Creating object of sub class
        s.display();  // Calling method to display values
    }
}