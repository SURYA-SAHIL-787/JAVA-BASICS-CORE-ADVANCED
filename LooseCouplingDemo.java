interface NotificationService {
    void sendNotification(String message);
}

class EmailService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SmsService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class AlertManager {
    private NotificationService service;

    AlertManager(NotificationService service) {
        this.service = service;
    }

    void triggerAlert(String msg) {
        System.out.println("Triggering alert...");
        service.sendNotification(msg);
    }
}

public class LooseCouplingDemo {
    public static void main(String[] args) {
        NotificationService email = new EmailService();
        NotificationService sms = new SmsService();

        AlertManager manager1 = new AlertManager(email);
        AlertManager manager2 = new AlertManager(sms);

        manager1.triggerAlert("Server is down");
        manager2.triggerAlert("Login OTP: 4567");
    }
}
