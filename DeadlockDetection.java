import java.util.*;

class DeadlockDetectedException extends Exception {
    DeadlockDetectedException(String msg) {
        super(msg);
    }
}

class DeadlockDetector {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int from, int to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(to);
    }

    public void detectDeadlock() throws DeadlockDetectedException {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();

        for (int node : graph.keySet()) {
            if (dfs(node, visited, path)) {
                throw new DeadlockDetectedException("Deadlock detected in resource graph");
            }
        }
    }

    private boolean dfs(int node, Set<Integer> visited, Set<Integer> path) {
        if (path.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        path.add(node);

        for (int next : graph.getOrDefault(node, new ArrayList<>())) {
            if (dfs(next, visited, path)) return true;
        }

        path.remove(node);
        return false;
    }
}

public class DeadlockDetection {
    public static void main(String[] args) {
        DeadlockDetector detector = new DeadlockDetector();

        detector.addEdge(1, 2);
        detector.addEdge(2, 3);
        detector.addEdge(3, 4);
        detector.addEdge(4, 2);

        Thread t = new Thread(() -> {
            try {
                detector.detectDeadlock();
                System.out.println("No deadlock found");
            } catch (DeadlockDetectedException e) {
                System.out.println(e.getMessage());
            }
        });

        t.start();
    }
}
