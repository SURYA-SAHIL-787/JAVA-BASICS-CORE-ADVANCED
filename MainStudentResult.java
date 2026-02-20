import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private int[] marks; // 3 subjects

    // Default constructor
    Student() {
        name = "Not Set";
        rollNo = 0;
        marks = new int[]{0, 0, 0};
    }

    // Parameterized constructor
    Student(String name, int rollNo, int m1, int m2, int m3) {
        this.name = name;
        this.rollNo = rollNo;
        marks = new int[3];
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
    }

    int total() {
        return marks[0] + marks[1] + marks[2];
    }

    double average() {
        return total() / 3.0;
    }

    String result() {
        return (average() >= 40) ? "PASS" : "FAIL";
    }

    void display() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Name   : " + name);
        System.out.println("RollNo : " + rollNo);
        System.out.println("Marks  : " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        System.out.println("Total  : " + total());
        System.out.println("Average: " + average());
        System.out.println("Result : " + result());
    }
}

public class MainStudentResult {
    static boolean validMark(int m) {
        return m >= 0 && m <= 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        int m1, m2, m3;

        System.out.print("Enter Marks 1 (0-100): ");
        m1 = sc.nextInt();
        System.out.print("Enter Marks 2 (0-100): ");
        m2 = sc.nextInt();
        System.out.print("Enter Marks 3 (0-100): ");
        m3 = sc.nextInt();

        if (!validMark(m1) || !validMark(m2) || !validMark(m3)) {
            System.out.println("Invalid marks entered! Marks must be 0 to 100.");
            sc.close();
            return;
        }

        Student s = new Student(name, roll, m1, m2, m3);
        s.display();

        sc.close();
    }
}
