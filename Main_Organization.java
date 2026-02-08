import java.util.Scanner;
class Employee {
    int empId;
    String name;
    double salary;
    void getEmployeeDetails(Scanner sc) {
        System.out.print("ENTER EMPLOYEE ID: ");
        empId = sc.nextInt();
        sc.nextLine();
        System.out.print("ENTER EMPLOYEE NAME: ");
        name = sc.nextLine();
        System.out.print("ENTER EMPLOYEE SALARY: ");
        salary = sc.nextDouble();
        sc.nextLine();
    }
    void displayEmployeeDetails() {
        System.out.println("EMPLOYEE ID     : " + empId);
        System.out.println("EMPLOYEE NAME   : " + name);
        System.out.println("EMPLOYEE SALARY : " + salary);
    }
}
class Manager extends Employee {
    String department;
    int teamSize;
    void getManagerDetails(Scanner sc) { 
        getEmployeeDetails(sc);
        System.out.print("ENTER MANAGER DEPARTMENT: ");
        department = sc.nextLine();
        System.out.print("ENTER TEAM SIZE: ");
        teamSize = sc.nextInt();
        sc.nextLine();
    }
    void displayManagerDetails() {
        displayEmployeeDetails();
        System.out.println("DEPARTMENT      : " + department);
        System.out.println("TEAM SIZE       : " + teamSize);
    }
}
public class Main_Organization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. EMPLOYEE");
        System.out.println("2. MANAGER");
        System.out.print("CHOOSE OPTION: ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println();
        if (choice == 1) {
            Employee e = new Employee();
            e.getEmployeeDetails(sc);
            System.out.println("\n--- DETAILS ---");
            e.displayEmployeeDetails();
        } else if (choice == 2) {
            Manager m = new Manager();
            m.getManagerDetails(sc);
            System.out.println("\n--- DETAILS ---");
            m.displayManagerDetails();
        } else {
            System.out.println("INVALID OPTION.");
        }
        sc.close();
    }
}
