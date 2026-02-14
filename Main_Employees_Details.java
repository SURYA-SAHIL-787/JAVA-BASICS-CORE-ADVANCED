import java.util.Scanner;
class Employee {
    String name;
    double salary;
    Employee(String name) {
        this.name = name;
        this.salary = 0.0;   
    }
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    void display() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name   : " + name);
        System.out.println("Salary : " + salary);
    }
}
public class Main_Employees_Details {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Create Employee with ONLY Name");
        System.out.println("2) Create Employee with Name + Salary");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine(); 
        if (choice == 1) {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();
            Employee e1 = new Employee(name);  
            e1.display();
        } else if (choice == 2) {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();
            System.out.print("Enter employee salary: ");
            double salary = sc.nextDouble();
            Employee e2 = new Employee(name, salary);
            e2.display();
        } else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}

