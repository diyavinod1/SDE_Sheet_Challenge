import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input k
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Arrays.sort(nums);

        int kthLargest = nums[n - k];
        int kthSmallest = nums[k - 1];

        System.out.println("Kth Largest Element: " + kthLargest);
        System.out.println("Kth Smallest Element: " + kthSmallest);

        sc.close();
    }
}
