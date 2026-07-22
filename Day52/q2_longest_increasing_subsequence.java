import java.util.*;

public class Main {

    public static int lengthOfLIS(int[] nums) {

        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : nums) {

            if (lis.isEmpty() || num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {

                int left = 0;
                int right = lis.size() - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    if (lis.get(mid) >= num) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                lis.set(left, num);
            }
        }

        return lis.size();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int ans = lengthOfLIS(nums);

        System.out.println("Length of Longest Increasing Subsequence: " + ans);

        sc.close();
    }
}
