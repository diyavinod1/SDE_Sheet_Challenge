class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        if (original == color)
            return image;

        dfs(image, sr, sc, original, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int original, int color) {

        image[r][c] = color;

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 &&
                nr < image.length &&
                nc >= 0 &&
                nc < image[0].length &&
                image[nr][nc] == original) {

                dfs(image, nr, nc, original, color);
            }
        }
    }
}
