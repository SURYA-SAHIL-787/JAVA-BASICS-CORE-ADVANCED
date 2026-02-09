import java.util.Scanner;

class Circle {
    double radius;

    // METHOD - CALCULATE AREA:
    double area() {
        return Math.PI * radius * radius;   
    }
}

public class MainCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Circle c1 = new Circle();

        // USER INPUT:
        System.out.print("Enter radius: ");
        c1.radius = sc.nextDouble();

        // CALCULATE AND PRINT AREA:
        System.out.println("Area of circle = " + c1.area());

        sc.close();
    }
}
