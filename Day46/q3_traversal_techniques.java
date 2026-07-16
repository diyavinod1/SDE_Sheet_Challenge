import java.util.*;

public class Main {

    static void bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++)
            graph.add(new ArrayList<>());

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter edges:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[V + 1];

        System.out.print("BFS Traversal: ");
        bfs(1, graph, visited);
    }
}
