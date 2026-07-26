import java.util.*;

public class Main {

    static class Job {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    // Binary Search to find the last non-conflicting job
    static int binarySearch(Job[] jobs, int index) {
        int low = 0, high = index - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (jobs[mid].end <= jobs[index].start) {
                if (mid + 1 < index && jobs[mid + 1].end <= jobs[index].start)
                    low = mid + 1;
                else
                    return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);

        // Sort jobs by end time
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));

        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {

            int includeProfit = jobs[i].profit;

            int last = binarySearch(jobs, i);
            if (last != -1)
                includeProfit += dp[last];

            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        int[] startTime = new int[n];
        int[] endTime = new int[n];
        int[] profit = new int[n];

        System.out.println("Enter Start Times:");
        for (int i = 0; i < n; i++)
            startTime[i] = sc.nextInt();

        System.out.println("Enter End Times:");
        for (int i = 0; i < n; i++)
            endTime[i] = sc.nextInt();

        System.out.println("Enter Profits:");
        for (int i = 0; i < n; i++)
            profit[i] = sc.nextInt();

        System.out.println("Maximum Profit: " + jobScheduling(startTime, endTime, profit));

        sc.close();
    }
}
