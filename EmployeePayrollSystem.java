import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollSystem {

    static abstract class Employee {
        private int id;
        private String name;
        protected double basePay;

        public Employee(int id, String name, double basePay) {
            this.id = id;
            this.name = name;
            this.basePay = basePay;
        }

        public abstract double calculateSalary();
        public abstract double calculateBonus();

        public double calculateTax(double salary) {
            // Simple slab: <=25k:0%, <=60k:10%, >60k:20%
            if (salary <= 25000) return 0;
            if (salary <= 60000) return salary * 0.10;
            return salary * 0.20;
        }

        public void printPayslip() {
            double salary = calculateSalary();
            double bonus = calculateBonus();
            double gross = salary + bonus;
            double tax = calculateTax(gross);
            double net = gross - tax;

            System.out.println("\nID: " + id + " | Name: " + name + " | Type: " + this.getClass().getSimpleName());
            System.out.println("BasePay: " + basePay);
            System.out.println("Salary: " + salary);
            System.out.println("Bonus: " + bonus);
            System.out.println("Gross: " + gross);
            System.out.println("Tax: " + tax);
            System.out.println("Net Pay: " + net);
        }
    }

    static class FullTimeEmployee extends Employee {
        private double hra;
        private double da;

        public FullTimeEmployee(int id, String name, double basePay, double hra, double da) {
            super(id, name, basePay);
            this.hra = hra;
            this.da = da;
        }

        @Override
        public double calculateSalary() {
            return basePay + hra + da;
        }

        @Override
        public double calculateBonus() {
            return basePay * 0.15;
        }
    }

    static class PartTimeEmployee extends Employee {
        private int hoursWorked;
        private double hourlyRate;

        public PartTimeEmployee(int id, String name, int hoursWorked, double hourlyRate) {
            super(id, name, 0);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }

        @Override
        public double calculateBonus() {
            return calculateSalary() * 0.05;
        }
    }

    static class Intern extends Employee {
        public Intern(int id, String name, double stipend) {
            super(id, name, stipend);
        }

        @Override
        public double calculateSalary() {
            return basePay;
        }

        @Override
        public double calculateBonus() {
            return 0;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(101, "Sahil", 50000, 8000, 5000));
        employees.add(new PartTimeEmployee(102, "Ravi", 120, 250));
        employees.add(new Intern(103, "Meena", 15000));

        for (Employee e : employees) {
            e.printPayslip();
        }
    }
}
