import java.util.Scanner;
class Temperature {
    double convert(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    double convert(double celsius, char type) {
        return celsius + 273.15;
    }
}
public class Main_F_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Temperature t = new Temperature();
        System.out.println("1) Celsius to Fahrenheit");
        System.out.println("2) Celsius to Kelvin");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        System.out.print("Enter temperature in Celsius: ");
        double c = sc.nextDouble();
        if (choice == 1) {
            System.out.println("Fahrenheit = " + t.convert(c)); 
        } else if (choice == 2) {
            System.out.println("Kelvin = " + t.convert(c, 'K')); 
        } else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}

