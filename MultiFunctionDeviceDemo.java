import java.util.Scanner;
interface Printable {
    void print();
}
interface Scannable {
    void scan();
}
class MultiFunctionDevice implements Printable, Scannable {
    String printText;
    String scanDocument;
    MultiFunctionDevice(String printText, String scanDocument) {
        this.printText = printText;
        this.scanDocument = scanDocument;
    }
    public void print() {
        System.out.println("Printing: " + printText);
    }
    public void scan() {
        System.out.println("Scanning: " + scanDocument);
    }
}
public class MultiFunctionDeviceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to print: ");
        String printText = sc.nextLine();
        System.out.print("Enter document name to scan: ");
        String scanDocument = sc.nextLine();
        MultiFunctionDevice device = new MultiFunctionDevice(printText, scanDocument);
        System.out.println("\nMulti Function Device Output:");
        device.print();
        device.scan();
        sc.close();
    }
}