import java.util.Scanner;
class FinalDemo {
    final double PI = 3.14159;
    void calculateArea(double radius) {
        double area = PI * radius * radius;
        System.out.println("PI (CONSTANT) = " + PI);
        System.out.println("RADIUS = " + radius);
        System.out.println("AREA OF CIRCLE = " + area);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER RADIUS: ");
        double r = sc.nextDouble();
        FinalDemo obj = new FinalDemo();
        obj.calculateArea(r);
        sc.close();
    }
}
