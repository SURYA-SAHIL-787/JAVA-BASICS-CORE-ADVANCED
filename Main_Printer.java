import java.util.Scanner;
class Printer {
    void print(int number) {
        System.out.println("Number: " + number);
    }
    void print(String message) {
        System.out.println("Message: " + message);
    }
    void print(int number, String message) {
        System.out.println("Number: " + number + ", Message: " + message);
    }
}
public class Main_Printer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Printer p = new Printer();
        System.out.println("Choose an option:");
        System.out.println("1. Print number");
        System.out.println("2. Print text");
        System.out.println("3. Print number and text");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();
            p.print(num);
        } 
        else if (choice == 2) {
            System.out.print("Enter a text message: ");
            String msg = sc.nextLine();
            p.print(msg);
        } 
        else if (choice == 3) {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter a text message: ");
            String msg = sc.nextLine();
            p.print(num, msg);
        } 
        else {
            System.out.println("Invalid choice!");
        }
        sc.close();
    }
}