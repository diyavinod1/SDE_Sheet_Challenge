class Solution {

    int[][] dp;

    public int solve(int i, int target, int[] coins) {

        if (i == 0) {
            if (target % coins[0] == 0)
                return 1;
            return 0;
        }

        if (dp[i][target] != -1)
            return dp[i][target];

        int notTake = solve(i - 1, target, coins);

        int take = 0;
        if (coins[i] <= target)
            take = solve(i, target - coins[i], coins);

        return dp[i][target] = take + notTake;
    }

    public int change(int amount, int[] coins) {

        int n = coins.length;

        dp = new int[n][amount + 1];

        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);

        return solve(n - 1, amount, coins);
    }
}
