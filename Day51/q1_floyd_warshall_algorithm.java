import java.util.*;

public class Main {

    static void floydWarshall(int[][] matrix, int V) {

        int INF = (int)1e9;

        // Convert -1 to INF
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = INF;
                }
            }
        }

        // Floyd Warshall Algorithm
        for (int via = 0; via < V; via++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {

                    if (matrix[i][via] != INF && matrix[via][j] != INF) {
                        matrix[i][j] = Math.min(matrix[i][j],
                                                matrix[i][via] + matrix[via][j]);
                    }
                }
            }
        }

        // Convert INF back to -1
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (matrix[i][j] == INF) {
                    matrix[i][j] = -1;
                }
            }
        }

        // Print Shortest Distance Matrix
        System.out.println("\nShortest Distance Matrix:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] matrix = new int[V][V];

        System.out.println("Enter the adjacency matrix (-1 for no edge):");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        floydWarshall(matrix, V);

        sc.close();
    }
}
