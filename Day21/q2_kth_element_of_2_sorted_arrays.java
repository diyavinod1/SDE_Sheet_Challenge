import java.util.*;

public class Main {

    public static int kthElement(int[] a, int[] b, int k) {

        // always binary search on smaller array
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int m = a.length;
        int n = b.length;

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {

            int cutA = (low + high) / 2;
            int cutB = k - cutA;

            int leftA = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : b[cutB - 1];

            int rightA = (cutA == m) ? Integer.MAX_VALUE : a[cutA];
            int rightB = (cutB == n) ? Integer.MAX_VALUE : b[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            }

            else if (leftA > rightB) {
                high = cutA - 1;
            } else {
                low = cutA + 1;
            }
        }

        return -1; // should never happen
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input first array
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }

        // Input second array
        int n = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int result = kthElement(a, b, k);
        System.out.println(result);

        sc.close();
    }
}
