class SleepThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Message " + i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ThreadSleepDemo {
    public static void main(String[] args) {
        SleepThread t1 = new SleepThread();
        t1.start();
    }
}
