import java.util.Scanner;
interface Shape {
    double area();  
}
class Circle implements Shape {
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    public double area() {
        return Math.PI * radius * radius;
    }
}
public class ShapeCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        double r = sc.nextDouble();
        Circle c = new Circle(r);
        System.out.println("Area of Circle = " + c.area());
        sc.close();
    }
}