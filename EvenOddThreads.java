import java.util.Scanner;

class EvenThread extends Thread {
    int limit;

    EvenThread(int limit) {
        this.limit = limit;
    }

    public void run() {
        System.out.println("Even numbers:");
        for (int i = 0; i <= limit; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

class OddThread extends Thread {
    int limit;

    OddThread(int limit) {
        this.limit = limit;
    }

    public void run() {
        System.out.println("Odd numbers:");
        for (int i = 0; i <= limit; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}

public class EvenOddThreads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter limit: ");
        int limit = sc.nextInt();

        EvenThread t1 = new EvenThread(limit);
        OddThread t2 = new OddThread(limit);

        t1.start();
        t2.start();

        sc.close();
    }
}