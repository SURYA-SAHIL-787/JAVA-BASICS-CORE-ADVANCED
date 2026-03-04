public class PaymentGateway {

    interface PaymentMethod {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentMethod {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card ending with "
                    + cardNumber.substring(cardNumber.length() - 4));
        }
    }

    static class UPIPayment implements PaymentMethod {
        private String upiId;

        public UPIPayment(String upiId) {
            this.upiId = upiId;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI ID: " + upiId);
        }
    }

    static class NetBankingPayment implements PaymentMethod {
        private String bankName;

        public NetBankingPayment(String bankName) {
            this.bankName = bankName;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Net Banking - " + bankName);
        }
    }

    static class PaymentProcessor {
        public void processPayment(PaymentMethod method, double amount) {
            if (amount <= 0) {
                System.out.println("Invalid payment amount.");
                return;
            }
            method.pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod p1 = new CreditCardPayment("1234567890123456");
        PaymentMethod p2 = new UPIPayment("sahil@upi");
        PaymentMethod p3 = new NetBankingPayment("SBI");

        processor.processPayment(p1, 2500);
        processor.processPayment(p2, 999.99);
        processor.processPayment(p3, 5000);
    }
}
