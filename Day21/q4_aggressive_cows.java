import java.util.*;

public class Main {

    // Check if we can place all cows with at least minDist distance
    static boolean canPlaceCows(int[] stalls, int k, int minDist) {

        int cowsPlaced = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= minDist) {
                cowsPlaced++;
                lastPosition = stalls[i];

                if (cowsPlaced >= k) {
                    return true;
                }
            }
        }

        return false;
    }

    static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                answer = mid;      // possible
                low = mid + 1;     // try bigger distance
            } else {
                high = mid - 1;    // reduce distance
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] stalls = new int[n];

        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(aggressiveCows(stalls, k));

        sc.close();
    }
}
