import java.util.Scanner;
class Student {
    String name;
    int marks;
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}
public class MainTopper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        Student[] s = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter student " + (i + 1) + " details:");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();
            s[i] = new Student(name, marks);
        }
        int topperIndex = 0;
        for (int i = 1; i < n; i++) {
            if (s[i].marks > s[topperIndex].marks) {
                topperIndex = i;
            }
        }
        System.out.println("\nTopper ");
        System.out.println("Name: " + s[topperIndex].name);
        System.out.println("Marks: " + s[topperIndex].marks);
        sc.close();
    }
}
