import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    void display() {
        System.out.println("\n Employee Details:");
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Salary : " + salary);
    }
}

public class MainEmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee e1 = new Employee();

        // USER INPUT
        System.out.print("Enter Employee ID: ");
        e1.id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Employee Name: ");
        e1.name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        e1.salary = sc.nextDouble();

        // DISPLAY
        e1.display();

        sc.close();
    }
}
