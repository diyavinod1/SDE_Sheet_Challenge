import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of first array
        System.out.print("Enter size of nums1: ");
        int n = sc.nextInt();

        int[] nums1 = new int[n];
        System.out.println("Enter elements of nums1:");
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        // Input size of second array
        System.out.print("Enter size of nums2: ");
        int m = sc.nextInt();

        int[] nums2 = new int[m];
        System.out.println("Enter elements of nums2:");
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        // Input k
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        List<Integer> sums = new ArrayList<>();

        // Generate all possible sums
        for (int a : nums1) {
            for (int b : nums2) {
                sums.add(a + b);
            }
        }

        // Sort in descending order
        sums.sort(Collections.reverseOrder());

        System.out.println("Maximum " + k + " Sum Combinations:");
        for (int i = 0; i < Math.min(k, sums.size()); i++) {
            System.out.print(sums.get(i) + " ");
        }

        sc.close();
    }
}
