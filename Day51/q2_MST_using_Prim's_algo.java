import java.util.*;

class Pair {
    int vertex;
    int weight;

    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Main {

    static int primMST(int V, ArrayList<ArrayList<Pair>> adj) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        boolean[] visited = new boolean[V];

        pq.offer(new Pair(0, 0)); // Start from vertex 0

        int mstWeight = 0;

        System.out.println("\nEdges in the MST:");

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.vertex;
            int wt = current.weight;

            if (visited[node])
                continue;

            visited[node] = true;
            mstWeight += wt;

            for (Pair neighbor : adj.get(node)) {

                if (!visited[neighbor.vertex]) {
                    pq.offer(new Pair(neighbor.vertex, neighbor.weight));
                }
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

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v weight):");

        for (int i = 0; i < E; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int wt = sc.nextInt();

            // Undirected Graph
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        int ans = primMST(V, adj);

        System.out.println("\nWeight of MST = " + ans);

        sc.close();
    }
}
