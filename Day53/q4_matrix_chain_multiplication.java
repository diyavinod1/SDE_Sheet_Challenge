import java.util.Scanner;

public class Main {

    public static int matrixChainMultiplication(int[] arr, int n) {
        int[][] dp = new int[n][n];

        // l = chain length
        for (int len = 2; len < n; len++) {

            for (int i = 1; i < n - len + 1; i++) {

                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = dp[i][k]
                             + dp[k + 1][j]
                             + arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of dimension array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the dimensions:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = matrixChainMultiplication(arr, n);

        System.out.println("Minimum number of multiplications = " + result);

        sc.close();
    }
}
