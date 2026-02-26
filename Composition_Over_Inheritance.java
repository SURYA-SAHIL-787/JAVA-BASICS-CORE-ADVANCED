interface Engine { void run(); }

class PetrolEngine implements Engine {
    public void run(){ System.out.println("Petrol engine running"); }
}
class ElectricEngine implements Engine {
    public void run(){ System.out.println("Electric motor running"); }
}

class Car {
    private Engine engine;               // composition
    Car(Engine e){ this.engine = e; }
    void setEngine(Engine e){ this.engine = e; }
    void drive(){ engine.run(); System.out.println("Car driving"); }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Car c = new Car(new PetrolEngine());
        c.drive();
        c.setEngine(new ElectricEngine()); // swap behavior at runtime
        c.drive();
    }
}
