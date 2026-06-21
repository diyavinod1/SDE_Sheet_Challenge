import java.util.*;

public class Main {

    // Check if allocation is possible
    static boolean canAllocate(int[] arr, int m, int maxPages) {
        int students = 1;
        int pagesSum = 0;

        for (int pages : arr) {

            if (pagesSum + pages <= maxPages) {
                pagesSum += pages;
            } else {
                students++;
                pagesSum = pages;

                if (students > m) {
                    return false;
                }
            }
        }

        return true;
    }

    static int allocateBooks(int[] arr, int m) {
        int n = arr.length;

        // Not enough books
        if (m > n) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, m, mid)) {
                answer = mid;
                high = mid - 1; // try smaller maximum
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        System.out.println(allocateBooks(arr, m));

        sc.close();
    }
}
