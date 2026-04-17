import java.util.*;

public class KruskalMST {
    static class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static class DisjointSet {
        int[] parent, size;
        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;

            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }
        }
    }

    static int kruskal(int V, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.wt));
        DisjointSet ds = new DisjointSet(V);
        int mstWeight = 0;

        for (Edge e : edges) {
            if (ds.find(e.u) != ds.find(e.v)) {
                mstWeight += e.wt;
                ds.union(e.u, e.v);
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        System.out.println(kruskal(V, edges));
    }
}
