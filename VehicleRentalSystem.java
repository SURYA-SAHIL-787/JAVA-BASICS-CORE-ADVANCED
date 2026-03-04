public class VehicleRentalSystem {

    static class Vehicle {
        protected String vehicleNumber;
        protected String brand;
        protected double baseRate;

        public Vehicle(String vehicleNumber, String brand, double baseRate) {
            this.vehicleNumber = vehicleNumber;
            this.brand = brand;
            this.baseRate = baseRate;
        }

        public double calculateRent(int days) {
            return baseRate * days;
        }

        public void display() {
            System.out.println(brand + " [" + vehicleNumber + "] Rent: ₹" + calculateRent(3));
        }
    }

    static class Car extends Vehicle {
        public Car(String vehicleNumber, String brand, double baseRate) {
            super(vehicleNumber, brand, baseRate);
        }

        @Override
        public double calculateRent(int days) {
            return baseRate * days + 1000;
        }
    }

    static class Bike extends Vehicle {
        public Bike(String vehicleNumber, String brand, double baseRate) {
            super(vehicleNumber, brand, baseRate);
        }

        @Override
        public double calculateRent(int days) {
            return baseRate * days + 200;
        }
    }

    static class Truck extends Vehicle {
        public Truck(String vehicleNumber, String brand, double baseRate) {
            super(vehicleNumber, brand, baseRate);
        }

        @Override
        public double calculateRent(int days) {
            return baseRate * days + 3000;
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("TN01C1234", "Hyundai", 1500),
                new Bike("TN02B5678", "Yamaha", 500),
                new Truck("TN03T9090", "Tata", 4000)
        };

        for (Vehicle v : vehicles) {
            v.display();
        }
    }
}
