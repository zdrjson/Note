// Solution2: DP 
// Time complexity: O(mn*log(mn))
// Space complexity: O(mn)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] d : dp)
            Arrays.fill(d, 1);
        int ans = 1;
        
        List<int[]> cells = new ArrayList<>();
        for (int y = 0; y < m; ++y)
            for (int x = 0; x < n; ++x)
                cells.add(new int[]{matrix[y][x], x, y});
        cells.sort((a, b) -> b[0] - a[0]);
        
        int[] dirs = {0, 1, 0, -1, 0};
        for (int[] cell : cells) {
            int x = cell[1];
            int y = cell[2];
            for (int i = 0; i < 4; ++i) {
                int tx = x + dirs[i];
                int ty = y + dirs[i + 1];
                if (tx < 0 || tx >= n || ty < 0 || ty >= m) continue;
                if (matrix[ty][tx] <= matrix[y][x]) continue;
                dp[y][x] = Math.max(dp[y][x], 1 + dp[ty][tx]);
            }
            ans = Math.max(ans, dp[y][x]);
        }
        return ans;
    }
}

// // Solution1: Recursion + Memoization
// // Time complexity: O(mn)
// // Space complexity: O(mn)
// class Solution {
//     private int m_;
//     private int n_;
//     private int[][] dp_;
//     private int[] dirs = {0, -1, 0, 1, 0};
//     public int longestIncreasingPath(int[][] matrix) {
//         if (matrix.length == 0) return 0;
//         m_ = matrix.length;
//         n_ = matrix[0].length;
//         dp_ = new int[m_][n_];
//         for (int[] d : dp_)
//             Arrays.fill(d, -1);
//         int ans = 0;
//         for (int y = 0; y < m_; ++y)
//             for (int x = 0; x < n_; ++x)
//                 ans = Math.max(ans, dfs(matrix, x, y));
//         return ans;
//     }
    
//     private int dfs(int[][] mat, int x, int y) {
//         if (dp_[y][x] != -1) return dp_[y][x];
//         dp_[y][x] = 1;
//         for (int i = 0; i < 4; ++i) {
//             int tx = x + dirs[i];
//             int ty = y + dirs[i + 1];
//             if (tx < 0 || ty < 0 || tx >= n_ || ty >= m_ || mat[ty][tx] <= mat[y][x]) continue;
//             dp_[y][x] = Math.max(dp_[y][x], 1 + dfs(mat, tx, ty));
//         }
//         return dp_[y][x];
//     }
// }
