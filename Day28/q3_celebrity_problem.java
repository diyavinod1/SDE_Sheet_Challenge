import java.util.*;

public class Main {

    public static int findCelebrity(int[][] mat, int n) {

        Stack<Integer> stack = new Stack<>();

        // Push all people onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Eliminate non-celebrities
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (mat[a][b] == 1) {
                // a knows b, so a cannot be celebrity
                stack.push(b);
            } else {
                // a does not know b, so b cannot be celebrity
                stack.push(a);
            }
        }

        int candidate = stack.pop();

        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int celebrity = findCelebrity(mat, n);

        if (celebrity == -1) {
            System.out.println("No Celebrity");
        } else {
            System.out.println("Celebrity is person: " + celebrity);
        }

        sc.close();
    }
}
