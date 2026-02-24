// Abstraction
abstract class Person {
    protected String name;   // Encapsulation

    Person(String name) {    // Constructor
        this.name = name;
    }

    abstract void work();    // Abstract Method
}

// Inheritance
class Student extends Person {
    private int marks;       // Encapsulation

    Student(String name, int marks) {
        super(name);
        this.marks = marks;
    }

    // Method Overriding (Polymorphism)
    @Override
    void work() {
        System.out.println(name + " is studying.");
    }

    void display() {
        System.out.println("Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Student("Surya", 95); // Polymorphism
        p.work();

        Student s = (Student) p;
        s.display();
    }
}
