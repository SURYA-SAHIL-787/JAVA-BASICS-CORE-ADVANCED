interface Printer {
    default void show() {
        System.out.println("Printer interface show()");
    }

    static void info() {
        System.out.println("Static method inside Printer interface");
    }
}

interface Scanner {
    default void show() {
        System.out.println("Scanner interface show()");
    }
}

class MultiFunctionDevice implements Printer, Scanner {
    @Override
    public void show() {
        System.out.println("Resolving conflict in MultiFunctionDevice");
        Printer.super.show();
        Scanner.super.show();
    }

    void deviceInfo() {
        System.out.println("This is a multi-function device");
    }
}

public class DefaultMethodConflictDemo {
    public static void main(String[] args) {
        MultiFunctionDevice device = new MultiFunctionDevice();
        device.show();
        device.deviceInfo();
        Printer.info();
    }
}
