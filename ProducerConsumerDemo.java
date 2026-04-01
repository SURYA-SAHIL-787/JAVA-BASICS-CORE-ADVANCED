import java.util.Scanner;

class Buffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        data = value;
        available = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Consumed: " + data);
        available = false;
        notify();
    }
}

class Producer extends Thread {
    private Buffer buffer;
    private int n;

    Producer(Buffer buffer, int n) {
        this.buffer = buffer;
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i++) {
            buffer.produce(i);
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;
    private int n;

    Consumer(Buffer buffer, int n) {
        this.buffer = buffer;
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i++) {
            buffer.consume();
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items to produce and consume: ");
        int n = sc.nextInt();

        Buffer buffer = new Buffer();

        Producer p = new Producer(buffer, n);
        Consumer c = new Consumer(buffer, n);

        p.start();
        c.start();

        sc.close();
    }
}