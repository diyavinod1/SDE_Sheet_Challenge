import java.util.*;

public class Main {

    static int[][] dp;

    static int solve(int eggs, int floors) {

        if (floors == 0 || floors == 1)
            return floors;

        if (eggs == 1)
            return floors;

        if (dp[eggs][floors] != -1)
            return dp[eggs][floors];

        int low = 1;
        int high = floors;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = (low + high) / 2;

            int breakEgg = solve(eggs - 1, mid - 1);
            int notBreak = solve(eggs, floors - mid);

            int temp = 1 + Math.max(breakEgg, notBreak);

            ans = Math.min(ans, temp);

            if (breakEgg < notBreak)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return dp[eggs][floors] = ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of eggs: ");
        int eggs = sc.nextInt();

        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();

        dp = new int[eggs + 1][floors + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        int result = solve(eggs, floors);

        System.out.println("Minimum number of attempts in worst case = " + result);

        sc.close();
    }
}
