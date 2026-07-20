import java.util.*;

public class Main {

    // DFS to store nodes according to finishing time
    static void dfs1(int node, boolean[] visited, Stack<Integer> stack,
                     ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                dfs1(next, visited, stack, adj);
            }
        }

        stack.push(node);
    }

    // DFS on reversed graph
    static void dfs2(int node, boolean[] visited,
                     ArrayList<ArrayList<Integer>> revAdj) {
        visited[node] = true;

        for (int next : revAdj.get(node)) {
            if (!visited[next]) {
                dfs2(next, visited, revAdj);
            }
        }
    }

    static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Store vertices according to finishing time
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, visited, stack, adj);
            }
        }

        // Step 2: Reverse the graph
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                revAdj.get(it).add(i);
            }
        }

        // Step 3: DFS on reversed graph
        Arrays.fill(visited, false);

        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                sccCount++;
                dfs2(node, visited, revAdj);
            }
        }

        return sccCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter directed edges (u v):");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }

        int ans = kosaraju(V, adj);

        System.out.println("Number of Strongly Connected Components: " + ans);

        sc.close();
    }
}
