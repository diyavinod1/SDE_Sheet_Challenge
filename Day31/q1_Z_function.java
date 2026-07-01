import java.util.*;

public class Main {

    public static int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n];

        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {

            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        int[] z = zFunction(s);

        System.out.println("Z Array:");
        for (int val : z) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
