import java.util.Scanner;

class Vehicle {
    String brand;
    int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

class Bus extends Vehicle {
    int seatingCapacity;

    Bus(String brand, int speed, int seatingCapacity) {
        super(brand, speed);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("\n--- Bus Details ---");
        super.displayInfo();
        System.out.println("Seating Capacity: " + seatingCapacity);
    }
}

class Truck extends Vehicle {
    double loadCapacity;

    Truck(String brand, int speed, double loadCapacity) {
        super(brand, speed);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("\n--- Truck Details ---");
        super.displayInfo();
        System.out.println("Load Capacity (tons): " + loadCapacity);
    }
}

public class MainVehicleSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1) Bus");
        System.out.println("2) Truck");
        System.out.print("Choose Vehicle Type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter Speed: ");
        int speed = sc.nextInt();

        Vehicle v;

        if (choice == 1) {
            System.out.print("Enter Seating Capacity: ");
            int seats = sc.nextInt();
            v = new Bus(brand, speed, seats);
        } else if (choice == 2) {
            System.out.print("Enter Load Capacity in tons: ");
            double load = sc.nextDouble();
            v = new Truck(brand, speed, load);
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        v.displayInfo(); // runtime polymorphism

        sc.close();
    }
}
