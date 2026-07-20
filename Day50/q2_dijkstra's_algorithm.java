import java.util.*;

public class Main {

    // Pair class to store (vertex, distance)
    static class Pair {
        int node, dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();
            int node = current.node;
            int dist = current.dist;

            // Ignore outdated entries
            if (dist > distance[node])
                continue;

            for (Pair neighbor : adj.get(node)) {

                int adjNode = neighbor.node;
                int edgeWeight = neighbor.dist;

                if (distance[node] + edgeWeight < distance[adjNode]) {

                    distance[adjNode] = distance[node] + edgeWeight;
                    pq.offer(new Pair(adjNode, distance[adjNode]));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v weight):");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // Undirected Graph
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        int[] shortestDistance = dijkstra(V, adj, source);

        System.out.println("\nShortest distances from source " + source + ":");

        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> " + shortestDistance[i]);
        }

        sc.close();
    }
}
