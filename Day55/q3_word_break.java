import java.util.*;

public class Main {

    public static boolean wordBreak(String s, Set<String> dict) {

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        System.out.print("Enter number of dictionary words: ");
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> dict = new HashSet<>();

        System.out.println("Enter dictionary words:");

        for (int i = 0; i < n; i++) {
            dict.add(sc.nextLine());
        }

        if (wordBreak(s, dict))
            System.out.println("Yes, the string can be segmented.");
        else
            System.out.println("No, the string cannot be segmented.");

        sc.close();
    }
}
