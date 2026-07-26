import java.util.*;

public class Main {

    // Function to check if substring is palindrome
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // Memoization function
    static int solve(String s, int i, int j, int[][] dp) {

        if (i >= j)
            return 0;

        if (isPalindrome(s, i, j))
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            int left, right;

            if (dp[i][k] != -1)
                left = dp[i][k];
            else {
                left = solve(s, i, k, dp);
                dp[i][k] = left;
            }

            if (dp[k + 1][j] != -1)
                right = dp[k + 1][j];
            else {
                right = solve(s, k + 1, j, dp);
                dp[k + 1][j] = right;
            }

            int temp = left + right + 1;
            min = Math.min(min, temp);
        }

        return dp[i][j] = min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = sc.next();

        int n = str.length();

        int[][] dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("Minimum Palindrome Partitions: " + solve(str, 0, n - 1, dp));

        sc.close();
    }
}
