import java.util.*;

public class BridgesInGraph {
    static int timer = 1;

    static void dfs(int node, int parent, boolean[] visited, int[] tin, int[] low,
                    ArrayList<ArrayList<Integer>> adj, List<List<Integer>> bridges) {
        visited[node] = true;
        tin[node] = low[node] = timer++;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;

            if (!visited[neighbor]) {
                dfs(neighbor, node, visited, tin, low, adj, bridges);
                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] > tin[node]) {
                    bridges.add(Arrays.asList(node, neighbor));
                }
            } else {
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }
    }

    static List<List<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfs(i, -1, visited, tin, low, adj, bridges);
        }

        return bridges;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(0); adj.get(0).add(2);
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(3).add(4); adj.get(4).add(3);

        System.out.println(criticalConnections(n, adj));
    }
}
