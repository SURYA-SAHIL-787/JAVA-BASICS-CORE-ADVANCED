class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread class: " + i);
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable interface: " + i);
        }
    }
}

public class ThreadCreationDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        MyRunnable obj = new MyRunnable();
        Thread t2 = new Thread(obj);

        t1.start();
        t2.start();
    }
}
