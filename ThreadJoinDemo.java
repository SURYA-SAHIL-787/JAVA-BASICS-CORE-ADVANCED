class WorkerThread extends Thread {
    private String name;

    WorkerThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " is working: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + " interrupted");
            }
        }
    }
}

public class ThreadJoinDemo {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread("Thread 1");
        WorkerThread t2 = new WorkerThread("Thread 2");

        t1.start();

        try {
            t1.join(); // Main thread waits until t1 finishes
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        t2.start();

        System.out.println("Main method finished");
    }
}
