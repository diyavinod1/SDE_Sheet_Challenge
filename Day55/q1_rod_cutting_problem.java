import java.util.*;

public class Main {
    public static int rodCutting(int[] price, int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) { // Rod length available
            for (int j = 1; j <= i; j++) { // Possible cut length
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rod length (N): ");
        int n = sc.nextInt();

        int[] price = new int[n];

        System.out.println("Enter the prices:");
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        int ans = rodCutting(price, n);

        System.out.println("Maximum Obtainable Value: " + ans);

        sc.close();
    }
}
