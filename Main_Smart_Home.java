import java.util.Scanner;
class SmartDevice {
    String deviceName;
    SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }
    void turnOn() {
        System.out.println(deviceName + " is turned ON.");
    }
}
class Light extends SmartDevice {
    Light() {
        super("Light");
    }
    @Override
    void turnOn() {
        System.out.println("Light is turned ON  (Brightening the room).");
    }
}
class Fan extends SmartDevice {
    Fan() {
        super("Fan");
    }
    @Override
    void turnOn() {
        System.out.println("Fan is turned ON  (Spinning fast).");
    }
}
class AirConditioner extends SmartDevice {
    AirConditioner() {
        super("Air Conditioner");
    }
    @Override
    void turnOn() {
        System.out.println("Air Conditioner is turned ON  (Cooling started).");
    }
}
public class Main_Smart_Home {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("SMART HOME DEVICE CONTROL");
        System.out.println("1. Light");
        System.out.println("2. Fan");
        System.out.println("3. Air Conditioner");
        System.out.print("Choose a device to turn ON (1/2/3): ");
        int choice = sc.nextInt();
        SmartDevice device;
        switch (choice) {
            case 1:
                device = new Light();
                break;
            case 2:
                device = new Fan();
                break;
            case 3:
                device = new AirConditioner();
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }
        device.turnOn();
        sc.close();
    }
} 

