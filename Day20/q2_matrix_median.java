class Solution {

    private static int countSmallerEqual(int[] row, int x) {
        int low = 0, high = row.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // count of elements <= x
    }

    public static int median(int matrix[][], int R, int C) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum elements
        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }

        int required = (R * C) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 0;

            for (int i = 0; i < R; i++) {
                count += countSmallerEqual(matrix[i], mid);
            }

            if (count <= required) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 3, 8},
            {2, 3, 4},
            {1, 2, 5}
        };

        System.out.println(median(matrix, 3, 3)); // 3
    }
}
