class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Count fresh oranges and add all rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int minutes = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];

                for (int[] d : dir) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        rottenThisMinute = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            if (rottenThisMinute)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
