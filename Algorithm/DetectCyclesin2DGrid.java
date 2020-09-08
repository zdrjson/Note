// Solution: DFS
// Finding a cycle in an undirected graph => visiting a node that has already been visited and it's not the parent node of the current node.
// b b
// b b
// null -> (0, 0) -> (0, 1) -> (1, 1) -> (1, 0) -> (0, 0)
// The second time we visit (0, 0) which has already been visited before and it's not the parent of the current node (1, 0) ((1, 0)’s parent is (1, 1)) which means we found a cycle.
// Time complexity: O(m*n)
// Space complexity: (m*n)
class Solution {
    private int m;
    private int n;
    private int[][] seen;
    private int[] dirs;
    private char[][] grid;
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        seen = new int[m][n];
        dirs = new int[]{0, 1, 0, -1, 0};
        this.grid = grid;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (seen[i][j]++ == 0 && dfs(i, j, -1, -1))
                    return true;
        return false;
    }
    private boolean dfs(int i, int j, int pi, int pj) {
        ++seen[i][j];
        for (int d = 0; d < 4; ++d) {
            int ni = i + dirs[d];
            int nj = j + dirs[d + 1];
            if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
            if (grid[ni][nj] != grid[i][j]) continue;
            if (seen[ni][nj] == 0) {
                if (dfs(ni, nj, i, j)) return true;
            } else if (ni != pi || nj != pj) {
                return true;
            }
        }
        return false;
    }
}
