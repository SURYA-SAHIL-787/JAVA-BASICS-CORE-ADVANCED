import devices.*;
import java.util.Scanner;

public class Smart_home {
    public static void 
    main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Light livingRoomLight = new Light();
        Thermostat thermostat = new Thermostat();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Smart Home Control ---");
            System.out.println("1. Turn ON Light");
            System.out.println("2. Turn OFF Light");
            System.out.println("3. Check Light Status");
            System.out.println("4. Turn ON Thermostat");
            System.out.println("5. Turn OFF Thermostat");
            System.out.println("6. Set Thermostat Temperature");
            System.out.println("7. Check Thermostat Status");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> livingRoomLight.turnOn();
                case 2 -> livingRoomLight.turnOff();
                case 3 -> livingRoomLight.status();
                case 4 -> thermostat.turnOn();
                case 5 -> thermostat.turnOff();
                case 6 -> {
                    System.out.print("Enter temperature: ");
                    int temp = sc.nextInt();
                    thermostat.setTemperature(temp);
                }
                case 7 -> thermostat.status();
                case 8 -> exit = true;
                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
        System.out.println("Exiting Smart Home System.");
    }
}



