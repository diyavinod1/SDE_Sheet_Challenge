class Solution {

    private static long power(long base, int exp, int m) {
        long result = 1;

        for (int i = 0; i < exp; i++) {
            result *= base;

            if (result > m) {
                return 2; // greater than M
            }
        }

        if (result == m) return 1; // equal to M
        return 0; // less than M
    }

    public static int NthRoot(int N, int M) {
        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long val = power(mid, N, M);

            if (val == 1) {
                return mid;
            } else if (val == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(3, 27)); // 3
        System.out.println(NthRoot(4, 69)); // -1
    }
}
