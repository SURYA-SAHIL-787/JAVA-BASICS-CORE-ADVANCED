class ComputeTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Compute Thread: Square of " + i + " = " + (i * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Compute thread interrupted");
            }
        }
    }
}
class LogTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Log Thread: Logging step " + i);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                System.out.println("Log thread interrupted");
            }
        }
    }
}
class DisplayTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Display Thread: Showing value " + i);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                System.out.println("Display thread interrupted");
            }
        }
    }
}
public class RunnableThreadsDemo {
    public static void main(String[] args) {
        Runnable compute = new ComputeTask();
        Runnable log = new LogTask();
        Runnable display = new DisplayTask();
        Thread t1 = new Thread(compute);
        Thread t2 = new Thread(log);
        Thread t3 = new Thread(display);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("All three threads have finished execution.");
    }
}