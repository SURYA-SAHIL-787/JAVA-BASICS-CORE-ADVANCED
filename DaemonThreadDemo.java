class BackgroundTask extends Thread {
    public void run() {
        while (true) {
            System.out.println("Daemon thread is running in background...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Daemon thread interrupted");
            }
        }
    }
}

public class DaemonThreadDemo {
    public static void main(String[] args) {
        BackgroundTask daemon = new BackgroundTask();

        daemon.setDaemon(true); // Must be called before start()
        daemon.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Main thread running: " + i);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }

        System.out.println("Main thread finished");
    }
}
