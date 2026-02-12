import java.util.Scanner;
class Person {
    String name;
    int age;
    void getPersonDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void displayPersonDetails() {
        System.out.println("NAME : " + "" + name);
        System.out.println("AGE  : " + "" + age);
    }
}
class Student extends Person {
    int rollNo;
    String course;
    void getStudentDetails(int rollNo, String course) {
        this.rollNo = rollNo;
        this.course = course;
    }
    void displayStudentDetails() {
        displayPersonDetails(); 
        System.out.println("ROLL NO    : " + rollNo);
        System.out.println("COURSE     : " + course);
    }
}
public class PersonToStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TO GET DETAILS FROM STUDENT:
        System.out.print("ENTER NAME: ");
        String name = sc.nextLine();
        System.out.print("ENTER AGE: ");
        int age = sc.nextInt();
        System.out.print("ENTER ROLL NO: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); 
        System.out.print("ENTER COURSE: ");
        String course = sc.nextLine();
        // TO DISPLAY DETAILS OF STUDENT:
        Student s = new Student();
        s.getPersonDetails(name, age);
        s.getStudentDetails(rollNo, course);
        s.displayStudentDetails();
        sc.close();
    }
}
