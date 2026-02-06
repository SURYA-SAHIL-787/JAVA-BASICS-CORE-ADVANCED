import java.util.Scanner;
class Complex {
    double real, imag;
    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
    static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imag + b.imag);
    }
    void display() {
        System.out.println(real + " + " + imag + "i");
    }
}
public class MainComplexNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Real Part Of First Complex Number: ");
        double r1 = sc.nextDouble();
        System.out.print("Enter Imaginary Part Of First Complex Number: ");
        double i1 = sc.nextDouble();

        System.out.print("Enter Real Part Of Second Complex Number: ");
        double r2 = sc.nextDouble();
        System.out.print("Enter Imaginary Part Of Second Complex Number: ");
        double i2 = sc.nextDouble();

        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);

        Complex sum = Complex.add(c1, c2);

        System.out.print("Sum = ");
        sum.display();

        sc.close();
    }
}
