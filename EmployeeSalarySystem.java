abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

class Developer extends Employee {
    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary + 10000;
    }
}

class Manager extends Employee {
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary + 20000 + (baseSalary * 0.1);
    }
}

public class EmployeeSalarySystem {
    public static void main(String[] args) {
        Employee e1 = new Developer("Sahil", 50000);
        Employee e2 = new Manager("Anita", 70000);

        e1.showDetails();
        System.out.println();
        e2.showDetails();
    }
}
