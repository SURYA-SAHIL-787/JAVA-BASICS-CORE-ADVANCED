import java.util.Scanner;

class Notification {
    void sendNotification(String message) {
        System.out.println("General Notification Sent: " + message);
    }
}

class EmailNotification extends Notification {
    @Override
    void sendNotification(String message) {
        System.out.println("Email Alert Sent: " + message);
    }

    void sendEmailNotification(String email, String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}

public class Main_Notification_System {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose notification type:");
        System.out.println("1. General Notification");
        System.out.println("2. Email Notification");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter notification message: ");
        String message = sc.nextLine();

        Notification n;

        if (choice == 1) {
            n = new Notification();
            n.sendNotification(message);
        }
        else if (choice == 2) {
            System.out.print("Enter email address: ");
            String email = sc.nextLine();

            EmailNotification en = new EmailNotification();
            en.sendEmailNotification(email, message);
        }
        else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}