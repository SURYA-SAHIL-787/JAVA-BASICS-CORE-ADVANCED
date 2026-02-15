class Student {
    String name;
    int rollNo;
    double cgpa;
    Student() {
        name = "Unknown";
        rollNo = 0;
        cgpa = 0.0;
    }
    void display() {
        System.out.println("--- Student Details (Default Values) ---");
        System.out.println("Name   : " + name);
        System.out.println("RollNo : " + rollNo);
        System.out.println("CGPA   : " + cgpa);
    }
}
public class Main_Student_Details {
    public static void main(String[] args) {
        Student s1 = new Student(); 
        s1.display();
    }
}

