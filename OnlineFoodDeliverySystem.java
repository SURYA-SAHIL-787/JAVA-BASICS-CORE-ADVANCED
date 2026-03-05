import java.util.ArrayList;
import java.util.List;

public class OnlineFoodDeliverySystem {

    static abstract class FoodItem {
        protected String name;
        protected double price;

        public FoodItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public abstract double finalPrice();
        public String getName() { return name; }
    }

    static class VegItem extends FoodItem {
        public VegItem(String name, double price) {
            super(name, price);
        }

        @Override
        public double finalPrice() {
            return price + (price * 0.05); // 5% tax
        }
    }

    static class NonVegItem extends FoodItem {
        public NonVegItem(String name, double price) {
            super(name, price);
        }

        @Override
        public double finalPrice() {
            return price + (price * 0.12); // 12% tax
        }
    }

    static class Dessert extends FoodItem {
        public Dessert(String name, double price) {
            super(name, price);
        }

        @Override
        public double finalPrice() {
            return price + (price * 0.08); // 8% tax
        }
    }

    static class Order {
        private List<FoodItem> items = new ArrayList<>();

        public void addItem(FoodItem item) {
            items.add(item);
        }

        public double calculateTotal() {
            double total = 0;
            for (FoodItem item : items) total += item.finalPrice();

            double delivery = (total < 500) ? 40 : 0;
            total += delivery;

            if (total > 1000) total *= 0.90; // 10% discount for big orders
            return total;
        }

        public void printBill() {
            System.out.println("\n--- ORDER BILL ---");
            for (FoodItem i : items) {
                System.out.println(i.getName() + " -> ₹" + i.finalPrice());
            }
            System.out.println("Total Payable: ₹" + calculateTotal());
        }
    }

    public static void main(String[] args) {
        Order o = new Order();
        o.addItem(new VegItem("Paneer Butter Masala", 250));
        o.addItem(new NonVegItem("Chicken Biryani", 350));
        o.addItem(new Dessert("Gulab Jamun", 120));

        o.printBill();
    }
}
