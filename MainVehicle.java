import java.util.Scanner;
class Vehicle {
    String brand;
    Vehicle(String brand) {
        this.brand = brand;
    }
    void showVehicle() {
        System.out.println("VEHICLE BRAND (PARENT) = " + brand);
    }
}
class Car extends Vehicle {
    String model;  
    Car(String brand, String model) {
        super(brand);         
        this.model = model;
    }
    void showCar() {
        System.out.println("BRAND (USING super.brand) = " + super.brand); 
        System.out.println("CAR MODEL (CHILD) = " + model);
    }
}
public class MainVehicle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER VEHICLE BRAND: ");
        String brand = sc.nextLine();
        System.out.print("ENTER CAR MODEL: ");
        String model = sc.nextLine();
        Car c = new Car(brand, model);
        System.out.println("OUTPUT");
        c.showVehicle(); 
        c.showCar();
        sc.close();
    }
}
