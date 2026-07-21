import java.util.*;

class Edge {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

class DisjointSet {

    int[] parent;
    int[] rank;

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int findParent(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = findParent(parent[node]);
    }

    void unionByRank(int u, int v) {

        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv)
            return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}

public class Main {

    static int kruskalMST(int V, ArrayList<Edge> edges) {

        Collections.sort(edges, (a, b) -> a.weight - b.weight);

        DisjointSet ds = new DisjointSet(V);

        int mstWeight = 0;

        System.out.println("\nEdges in the MST:");

        for (Edge edge : edges) {

            int u = edge.u;
            int v = edge.v;
            int wt = edge.weight;

            if (ds.findParent(u) != ds.findParent(v)) {

                ds.unionByRank(u, v);

                mstWeight += wt;

                System.out.println(u + " - " + v + " : " + wt);
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();

        System.out.println("Enter edges (u v weight):");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            edges.add(new Edge(u, v, wt));
        }

        int ans = kruskalMST(V, edges);

        System.out.println("\nTotal Weight of MST = " + ans);

        sc.close();
    }
}
