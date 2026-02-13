import java.util.Scanner;
class ShapeArea {
    double area(double radius) {
        return 3.14159 * radius * radius;
    }
    double area(double length, double breadth) {
        return length * breadth;
    }
}
public class Main_Calculate_Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShapeArea s = new ShapeArea();
        System.out.println("1) Area of Circle");
        System.out.println("2) Area of Rectangle");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.print("Enter radius: ");
            double r = sc.nextDouble();
            System.out.println("Area of Circle = " + s.area(r));
        } else if (choice == 2) {
            System.out.print("Enter length: ");
            double l = sc.nextDouble();
            System.out.print("Enter breadth: ");
            double b = sc.nextDouble();
            System.out.println("Area of Rectangle = " + s.area(l, b));
        } else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
