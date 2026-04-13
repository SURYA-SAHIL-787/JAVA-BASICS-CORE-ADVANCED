import java.util.*;

public class ArrayJumpPenalty {

    public static int minCost(int[] arr) {
        int n = arr.length;

        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(arr[i], key -> new ArrayList<>()).add(i);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        boolean[] usedValueJump = new boolean[n];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int index = current[0];
            int cost = current[1];

            if (cost > dist[index]) {
                continue;
            }

            if (index == n - 1) {
                return cost;
            }

            // Jump to i + 1
            if (index + 1 < n && dist[index + 1] > cost + 1) {
                dist[index + 1] = cost + 1;
                pq.offer(new int[]{index + 1, dist[index + 1]});
            }

            // Jump to i + 2
            if (index + 2 < n && dist[index + 2] > cost + 1) {
                dist[index + 2] = cost + 1;
                pq.offer(new int[]{index + 2, dist[index + 2]});
            }

            // Jump to same-value indices with penalty
            for (int next : positions.get(arr[index])) {
                if (next != index && dist[next] > cost + 3) {
                    dist[next] = cost + 3;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 5, 3, 5, 4};
        System.out.println("Minimum Cost: " + minCost(arr));
    }
}
