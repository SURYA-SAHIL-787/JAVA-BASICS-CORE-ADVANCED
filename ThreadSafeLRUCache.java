import java.util.*;

class KeyNotFoundException extends Exception {
    KeyNotFoundException(String msg) {
        super(msg);
    }
}

class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> map;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public synchronized int get(int key) throws KeyNotFoundException {
        if (!map.containsKey(key)) {
            throw new KeyNotFoundException("Key not found: " + key);
        }
        return map.get(key);
    }

    public synchronized void put(int key, int value) {
        if (map.size() >= capacity && !map.containsKey(key)) {
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
        map.put(key, value);
    }

    public synchronized void display() {
        System.out.println(map);
    }
}

public class ThreadSafeLRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        Thread t1 = new Thread(() -> {
            cache.put(1, 100);
            cache.put(2, 200);
            cache.put(3, 300);
            cache.display();
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Value: " + cache.get(2));
                cache.put(4, 400);
                cache.display();
                System.out.println(cache.get(1));
            } catch (KeyNotFoundException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        });

        t1.start();
        t2.start();
    }
}
