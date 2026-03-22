import java.util.Scanner;
interface Booking {
    void bookRide();
}
interface Payment {
    void makePayment();
}
class RideService implements Booking, Payment {
    String pickupLocation;
    String dropLocation;
    double fare;
    RideService(String pickupLocation, String dropLocation, double fare) {
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.fare = fare;
    }
    public void bookRide() {
        System.out.println("Ride Booked Successfully");
        System.out.println("Pickup Location: " + pickupLocation);
        System.out.println("Drop Location: " + dropLocation);
    }
    public void makePayment() {
        System.out.println("Payment Successful");
        System.out.println("Amount Paid: " + fare);
    }
}
public class RideServiceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter pickup location: ");
        String pickup = sc.nextLine();
        System.out.print("Enter drop location: ");
        String drop = sc.nextLine();
        System.out.print("Enter fare amount: ");
        double fare = sc.nextDouble();
        RideService ride = new RideService(pickup, drop, fare);
        System.out.println("\nRide Service Output:");
        ride.bookRide();
        ride.makePayment();
        sc.close();
    }
}