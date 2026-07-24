import java.util.*;

public class Main {

    static void subsetSum(int index, int sum, int[] arr, ArrayList<Integer> ans) {

        if (index == arr.length) {
            ans.add(sum);
            return;
        }

        // Pick the current element
        subsetSum(index + 1, sum + arr[index], arr, ans);

        // Don't pick the current element
        subsetSum(index + 1, sum, arr, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> ans = new ArrayList<>();

        subsetSum(0, 0, arr, ans);

        Collections.sort(ans);

        System.out.println("Subset sums in increasing order:");

        for (int sum : ans) {
            System.out.print(sum + " ");
        }

        sc.close();
    }
}
