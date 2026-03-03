interface Sender {
    void send(String message);
}

class EmailSender implements Sender {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SmsSender implements Sender {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class NotificationService {
    private Sender sender;

    public NotificationService(Sender sender) {
        this.sender = sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public void notifyUser(String message) {
        sender.send(message);
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        NotificationService service = new NotificationService(new EmailSender());
        service.notifyUser("Your order has been shipped.");

        service.setSender(new SmsSender());
        service.notifyUser("OTP is 4589.");
    }
}
