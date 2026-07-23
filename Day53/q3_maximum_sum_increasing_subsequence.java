import java.util.Scanner;

public class Main {

    public static int maximumSumIS(int[] arr, int n) {
        int[] dp = new int[n];

        // Initialize dp with array values
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        // Compute maximum sum increasing subsequence
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        // Find maximum value in dp[]
        int maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = maximumSumIS(arr, n);

        System.out.println("Maximum Sum Increasing Subsequence = " + result);

        sc.close();
    }
}
