class Download {
    static int progress = 0;
    static boolean downloading = true;
}
class ProgressThread extends Thread {
    public void run() {
        while (Download.progress < 100) {
            Download.progress += 10;
            System.out.println("Downloading... " + Download.progress + "%");
            try {
                Thread.sleep(500); // delay to simulate download time
            } catch (InterruptedException e) {
                System.out.println("Progress thread interrupted");
            }
        }
        Download.downloading = false;
    }
}
class DisplayThread extends Thread {
    public void run() {
        while (Download.downloading) {
            System.out.println("Current Progress: " + Download.progress + "%");
            try {
                Thread.sleep(500); // delay for display update
            } catch (InterruptedException e) {
                System.out.println("Display thread interrupted");
            }
        }
        System.out.println("Download Completed: " + Download.progress + "%");
    }
}
public class FileDownloadSimulation {
    public static void main(String[] args) {
        ProgressThread t1 = new ProgressThread();
        DisplayThread t2 = new DisplayThread();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}