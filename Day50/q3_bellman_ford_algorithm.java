import java.util.*;

public class Main {

    // Edge class
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int[] bellmanFord(int V, ArrayList<Edge> edges, int source) {

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i <= V - 1; i++) {

            for (Edge edge : edges) {

                int u = edge.src;
                int v = edge.dest;
                int wt = edge.weight;

                if (distance[u] != Integer.MAX_VALUE &&
                    distance[u] + wt < distance[v]) {

                    distance[v] = distance[u] + wt;
                }
            }
        }

        // Check for negative weight cycle
        for (Edge edge : edges) {

            int u = edge.src;
            int v = edge.dest;
            int wt = edge.weight;

            if (distance[u] != Integer.MAX_VALUE &&
                distance[u] + wt < distance[v]) {

                return new int[]{-1};
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

        ArrayList<Edge> edges = new ArrayList<>();

        System.out.println("Enter directed edges (source destination weight):");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges.add(new Edge(u, v, w));
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        int[] result = bellmanFord(V, edges, source);

        if (result.length == 1 && result[0] == -1) {
            System.out.println("Negative Weight Cycle Detected");
            System.out.println("-1");
        } else {
            System.out.println("\nShortest distances from source " + source + ":");
            for (int i = 0; i < V; i++) {
                if (result[i] == Integer.MAX_VALUE)
                    System.out.println("Vertex " + i + " -> INF");
                else
                    System.out.println("Vertex " + i + " -> " + result[i]);
            }
        }

        sc.close();
    }
}
