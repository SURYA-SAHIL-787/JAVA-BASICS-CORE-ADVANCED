class MyThread extends Thread {
    public void run() {
        try {
            System.out.println("Inside run() method");
            Thread.sleep(1000); // makes thread go to TIMED_WAITING
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        System.out.println("State after creation: " + t1.getState());
        t1.start();
        System.out.println("State after start(): " + t1.getState());

        try {
            Thread.sleep(200); 
            System.out.println("State during sleep: " + t1.getState());
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("State after completion: " + t1.getState());
    }
}