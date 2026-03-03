interface Rewardable {
    void giveRewardPoints(double amount);
}

abstract class Payment {
    protected String user;

    public Payment(String user) {
        this.user = user;
    }

    abstract double pay(double amount);
}

class CreditCardPayment extends Payment implements Rewardable {
    public CreditCardPayment(String user) {
        super(user);
    }

    @Override
    double pay(double amount) {
        double finalAmount = amount + (amount * 0.02);
        System.out.println(user + " paid using Credit Card: " + finalAmount);
        giveRewardPoints(amount);
        return finalAmount;
    }

    @Override
    public void giveRewardPoints(double amount) {
        System.out.println("Reward Points Earned: " + (int)(amount / 10));
    }
}

class UpiPayment extends Payment {
    public UpiPayment(String user) {
        super(user);
    }

    @Override
    double pay(double amount) {
        double finalAmount = amount - 20;
        System.out.println(user + " paid using UPI: " + finalAmount);
        return finalAmount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment("Sahil");
        Payment p2 = new UpiPayment("Rahul");

        p1.pay(2000);
        p2.pay(2000);
    }
}
