import java.util.*;

public class PrimMST {
    static class Pair {
        int node, wt;
        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    static int spanningTree(int V, ArrayList<ArrayList<Pair>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.offer(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.wt;

            if (visited[node]) continue;
            visited[node] = true;
            sum += wt;

            for (Pair neighbor : adj.get(node)) {
                if (!visited[neighbor.node]) {
                    pq.offer(new Pair(neighbor.node, neighbor.wt));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 5));
        adj.get(0).add(new Pair(2, 1));
        adj.get(1).add(new Pair(0, 5));
        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(0, 1));
        adj.get(2).add(new Pair(1, 3));

        System.out.println(spanningTree(V, adj));
    }
}
