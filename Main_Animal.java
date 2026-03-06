class Animal {
    void sound() {
        System.out.println("Animal Makes A Sound");
    }
}
class Dog extends Animal {
    void sound() {
        System.out.println("Dog Barks");
        
    }
}

public class Main_Animal {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound();

        Dog d = new Dog();
        d.sound();
    }
}