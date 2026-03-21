import java.util.*;

public class MinCostToConnectPoints {

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{0, 0}); // {cost, pointIndex}
        int totalCost = 0;
        int edgesUsed = 0;

        while (edgesUsed < n) {
            int[] current = minHeap.poll();
            int cost = current[0];
            int u = current[1];

            if (visited[u]) continue;

            visited[u] = true;
            totalCost += cost;
            edgesUsed++;

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int newCost = Math.abs(points[u][0] - points[v][0]) +
                                  Math.abs(points[u][1] - points[v][1]);
                    minHeap.offer(new int[]{newCost, v});
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[][] points = {
            {0, 0},
            {2, 2},
            {3, 10},
            {5, 2},
            {7, 0}
        };

        System.out.println(minCostConnectPoints(points));
    }
}
