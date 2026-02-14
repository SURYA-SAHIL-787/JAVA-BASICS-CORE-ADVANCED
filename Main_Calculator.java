import java.util.Scanner;
class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
}
public class Main_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.println("1) Addition of Integers");
        System.out.println("2) Addition of Floating-Point Numbers");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Enter first integer: ");
            int a = sc.nextInt();
            System.out.print("Enter second integer: ");
            int b = sc.nextInt();
            int result = calc.add(a, b);
            System.out.println("Result = " + result);
        } else if (choice == 2) {
            System.out.print("Enter first decimal number: ");
            double a = sc.nextDouble();
            System.out.print("Enter second decimal number: ");
            double b = sc.nextDouble();
            double result = calc.add(a, b);
            System.out.println("Result = " + result);
        } else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
