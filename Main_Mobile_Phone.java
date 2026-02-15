import java.util.Scanner;
class MobilePhone {
    String brand;
    double price;
    MobilePhone(String brand) {
        this.brand = brand;
        this.price = 0.0; 
    }
    MobilePhone(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
    void display() {
        System.out.println("\n--- Mobile Phone Details ---");
        System.out.println("Brand : " + brand);
        System.out.println("Price : " + price);
    }
}
public class Main_Mobile_Phone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Create Mobile with ONLY Brand");
        System.out.println("2) Create Mobile with Brand + Price");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine(); 
        if (choice == 1) {
            System.out.print("Enter brand name: ");
            String brand = sc.nextLine();
            MobilePhone m1 = new MobilePhone(brand); 
            m1.display();
        } else if (choice == 2) {
            System.out.print("Enter brand name: ");
            String brand = sc.nextLine();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            MobilePhone m2 = new MobilePhone(brand, price); 
            m2.display();
        } else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
