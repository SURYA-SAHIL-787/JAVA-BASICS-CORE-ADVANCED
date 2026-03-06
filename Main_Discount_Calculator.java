import java.util.Scanner;
class DiscountCalculator {
    double calculateDiscount(double price) {
        return price * 0.05;
    }
    double calculateDiscount(double price, String membershipType) {
        membershipType = membershipType.toLowerCase();
        double rate;
        if (membershipType.equals("silver")) rate = 0.10;
        else if (membershipType.equals("gold")) rate = 0.15;
        else if (membershipType.equals("platinum")) rate = 0.20;
        else rate = 0.05;
        return price * rate;
    }
    double calculateDiscount(double price, String membershipType, String couponCode) {
        double membershipDiscount = calculateDiscount(price, membershipType);
        couponCode = couponCode.toUpperCase();
        double couponDiscount = 0;
        if (couponCode.equals("SAVE50")) couponDiscount = 50;      
        else if (couponCode.equals("OFF10")) couponDiscount = price * 0.10; 
        else if (couponCode.equals("FREESHIP")) couponDiscount = 0; 
        return membershipDiscount + couponDiscount;
    }
}
public class Main_Discount_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DiscountCalculator dc = new DiscountCalculator();
        System.out.println("DISCOUNT CALCULATOR");
        System.out.println("1. Price only");
        System.out.println("2. Price + Membership");
        System.out.println("3. Price + Membership + Coupon");
        System.out.print("Enter choice (1/2/3): ");
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        double discount = 0;
        switch (choice) {
            case 1:
                discount = dc.calculateDiscount(price);
                break;
            case 2:
                System.out.print("Enter membership type (Silver/Gold/Platinum/None): ");
                String membership = sc.nextLine();
                discount = dc.calculateDiscount(price, membership);
                break;
            case 3:
                System.out.print("Enter membership type (Silver/Gold/Platinum/None): ");
                String membership2 = sc.nextLine();
                System.out.print("Enter coupon code (SAVE50/OFF10/FREESHIP/Any): ");
                String coupon = sc.nextLine();
                discount = dc.calculateDiscount(price, membership2, coupon);
                break;
            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }
        double finalPrice = price - discount;
        if (finalPrice < 0) finalPrice = 0;
        System.out.println("\n--- BILL ---");
        System.out.printf("Original Price : ₹%.2f%n", price);
        System.out.printf("Discount       : ₹%.2f%n", discount);
        System.out.printf("Final Price    : ₹%.2f%n", finalPrice);
        sc.close();
    }
}