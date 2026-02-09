import java.util.Scanner;

class Student {
    private int m1, m2, m3;

    Student(int m1, int m2, int m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    int total() {
        return m1 + m2 + m3;
    }

    double average() {
        return total() / 3.0;
    }
}

public class Main_Students_Marks_Total_Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks of Subject 1: ");
        int m1 = sc.nextInt();

        System.out.print("Enter marks of Subject 2: ");
        int m2 = sc.nextInt();

        System.out.print("Enter marks of Subject 3: ");
        int m3 = sc.nextInt();

        Student s = new Student(m1, m2, m3);

        System.out.println("Total = " + s.total());
        System.out.println("Average = " + s.average());

        sc.close();
    }
}
