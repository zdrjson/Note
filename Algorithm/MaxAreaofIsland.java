/**
 * Use DFS to find the connected components
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int h = grid.length;
        if (h == 0) {
            return 0;
        }
        int w = grid[0].length;
        int ans = 0;
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                ans = Math.max(ans, dfs(grid, j, i, w, h));
            }
        }
        return ans;
    }
    private int dfs(int[][] grid, int x, int y, int w, int h) {
        if (x < 0 || y < 0 || x >= w || y >= h || grid[y][x] == 0) return 0;

        grid[y][x] = 0;

        return dfs(grid, x - 1, y, w, h)
                + dfs(grid, x + 1, y, w, h)
                + dfs(grid, x, y - 1, w, h)
                + dfs(grid, x, y + 1, w, h)
                + 1;
    }

}