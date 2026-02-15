import java.util.Scanner;
class Rectangle {
    double length;
    double breadth;
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    double area() {
        return length * breadth;
    }
    void display() {
        System.out.println("\n--- Rectangle Details ---");
        System.out.println("Length  : " + length);
        System.out.println("Breadth : " + breadth);
        System.out.println("Area    : " + area());
    }
}
public class Main_Rectangle_Area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        double length = sc.nextDouble();
        System.out.print("Enter breadth: ");
        double breadth = sc.nextDouble();
        Rectangle r1 = new Rectangle(length, breadth);
        r1.display();
        sc.close();
    }
}

