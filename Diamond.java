interface A { default void hello(){ System.out.println("Hello from A"); } }
interface B { default void hello(){ System.out.println("Hello from B"); } }

class C implements A, B {
    @Override
    public void hello() {
        A.super.hello();                 // choose A explicitly
        B.super.hello();                 // or call both
        System.out.println("Hello from C");
    }
}

public class DiamondDefaultDemo {
    public static void main(String[] args) {
        new C().hello();
    }
}
