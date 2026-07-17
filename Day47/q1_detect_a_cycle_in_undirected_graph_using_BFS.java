import java.util.*;

class Pair {
    int node, parent;

    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class Main {

    static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> graph) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, graph, visited))
                    return true;
            }
        }
        return false;
    }

    static boolean bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, -1));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int parent = current.parent;

            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new Pair(neighbor, node));
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if (detectCycle(V, graph))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }
}
