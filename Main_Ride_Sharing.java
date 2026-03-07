import java.util.Scanner;
class Ride {
    double calculateFare(double distance) {
        return 0;
    }
}
class BikeRide extends Ride {
    @Override
    double calculateFare(double distance) {
        double baseFare = 20;
        double perKm = 8;
        return baseFare + (perKm * distance);
    }
}
class AutoRide extends Ride {
    @Override
    double calculateFare(double distance) {
        double baseFare = 30;
        double perKm = 12;
        return baseFare + (perKm * distance);
    }
}
class CarRide extends Ride {
    @Override
    double calculateFare(double distance) {
        double baseFare = 50;
        double perKm = 18;
        return baseFare + (perKm * distance);
    }
}
public class Main_Ride_Sharing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("RIDE SHARING FARE CALCULATOR");
        System.out.println("1. Bike Ride");
        System.out.println("2. Auto Ride");
        System.out.println("3. Car Ride");
        System.out.print("Choose ride type (1/2/3): ");
        int choice = sc.nextInt();
        System.out.print("Enter distance (in km): ");
        double distance = sc.nextDouble();
        Ride ride; 
        switch (choice) {
            case 1:
                ride = new BikeRide();
                break;
            case 2:
                ride = new AutoRide();
                break;
            case 3:
                ride = new CarRide();
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }
        double fare = ride.calculateFare(distance);
        System.out.println("\n--- FARE DETAILS ---");
        System.out.printf("Distance: %.2f km%n", distance);
        System.out.printf("Total Fare: ₹%.2f%n", fare);
        sc.close();
    }
}