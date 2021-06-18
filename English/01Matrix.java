// // Solution 1: DP
// // Two passes:
// // 1. down, right
// // 2. up. left
// // Time complexity: O(mn)
// // Space complexity: O(mn)
// class Solution {
//     public int[][] updateMatrix(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][] ans = new int[m][n];
//         for (int[] r : ans)
//             Arrays.fill(r, Integer.MAX_VALUE - m * n);
//         for (int i = 0; i < m; ++i)
//             for (int j = 0; j < n; ++j) {
//                 if (matrix[i][j] == 1) {
//                     if (i > 0) ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
//                     if (j > 0) ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
//                 } else {
//                     ans[i][j] = 0;
//                 }
//             }
//         for (int i = m - 1; i >= 0; --i)
//             for (int j = n - 1; j >= 0; --j) {
//                 if (i < m - 1) ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
//                 if (j < n - 1) ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
//             }
//         return ans;
//     }
// }

// Soluiton: BFS
// Start from all 0 cells and find shortest paths to rest of the cells.
// Time complexity: O(mn)
// Space complexity: O(mn)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        final int m = matrix.length;;
        final int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] seen = new int[m][n];
        int[][] ans = new int[m][n];
        for (int[] r : ans)
            Arrays.fill(r, Integer.MAX_VALUE);
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    seen[i][j] = 1;
                }
            }
        
        int[] dirs = {0, -1, 0, 1, 0};
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- != 0) {
                int[] pair = q.poll();
                int i = pair[0];
                int j = pair[1];
                ans[i][j] = steps;
                for (int k = 0; k < 4; ++k) {
                    int x = j + dirs[k];
                    int y = i + dirs[k + 1];
                    if (x < 0 || x >= n || y < 0 || y >= m || seen[y][x] == 1) continue;
                    seen[y][x] = 1;
                    q.offer(new int[]{y, x});
                }
            }
            ++steps;
        }
        
        return ans;
    }
};
