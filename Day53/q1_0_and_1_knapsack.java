import java.util.Scanner;

public class Main {

    public static int knapsack(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                // Not take the item
                dp[i][w] = dp[i - 1][w];

                // Take the item if possible
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i][w],
                            val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt = new int[n];

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int ans = knapsack(wt, val, n, W);

        System.out.println("Maximum value that can be obtained = " + ans);

        sc.close();
    }
}
