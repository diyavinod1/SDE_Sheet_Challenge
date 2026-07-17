import java.util.*;

public class Main {

    static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, node, graph, visited))
                    return true;
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> graph) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, graph, visited))
                    return true;
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
