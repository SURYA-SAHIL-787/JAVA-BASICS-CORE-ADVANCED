import java.util.*;

class QueueFullException extends Exception {
    QueueFullException(String msg) {
        super(msg);
    }
}

class QueueEmptyException extends Exception {
    QueueEmptyException(String msg) {
        super(msg);
    }
}

class BoundedQueue {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    BoundedQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws QueueFullException, InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }

        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized int consume() throws QueueEmptyException, InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }

        int value = queue.remove();
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}

public class BoundedBlockingQueueDemo {
    public static void main(String[] args) {
        BoundedQueue bq = new BoundedQueue(3);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    bq.produce(i);
                    Thread.sleep(300);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    bq.consume();
                    Thread.sleep(600);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        producer.start();
        consumer.start();
    }
}
