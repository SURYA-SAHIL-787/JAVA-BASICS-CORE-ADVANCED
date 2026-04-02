import java.util.Scanner;
class Counter {
    int count = 0;
    void increment() {
        count++;
    }
}
public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of increments for each thread: ");
        int n = sc.nextInt();
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Expected count: " + (2 * n));
        System.out.println("Actual final count: " + counter.count);
        sc.close();
    }
}