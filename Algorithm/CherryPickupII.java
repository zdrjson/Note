// // Solution: DP
// // dp[y][x1][x2] := max cherry when ro1 at (x1, y) and ro2 at (x2, y)
// // dp[y][x1][x2] = max(dp[y+1][x1+dx1][x2+dx2]) -1 <= dx1,dx2 <= 1
// // Time complexity: O(c^2*r)
// // Space complexity: O(c^2*r)
// class Solution {
//     private int r;
//     private int c;
//     private int[][] grid;
//     private int[][][] cache;
//     public int cherryPickup(int[][] grid) {
//         r = grid.length;
//         c = grid[0].length;
//         this.grid = grid;
//         cache = new int[r][c][c];
//         for (int[][] col1 : cache)
//             for (int[] col2 : col1)
//                 Arrays.fill(col2, -1);
//         return dp(0, 0, c - 1);
//     }
//     private int dp(int y, int x1 , int x2) {
//         if (x1 < 0 || x1 >= c || x2 < 0 || x2 >= c || y < 0 || y >= r) return 0;
//         int ans = cache[y][x1][x2];
//         if (ans != -1) return ans;
//         int cur = grid[y][x1] + (x1 != x2 ? 1 : 0) * grid[y][x2];
//         for (int d1 = -1; d1 <= 1; ++d1)
//             for (int d2 = -1; d2 <= 1; ++d2)
//                 ans = Math.max(ans, cur + dp(y + 1, x1 + d1, x2 + d2));
//         return cache[y][x1][x2] = ans;
//     }
// }

// // Bottom-up
// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int r = grid.length;
//         int c = grid[0].length;
//         int[][][] dp = new int[r + 2][c + 2][c + 2];
//         for (int y = r; y >= 1; --y)
//             for (int x1 = 1; x1 <= c; ++x1)
//                 for (int x2 = 1; x2 <= c; ++x2) {
//                     int cur = grid[y - 1][x1 - 1] + (x1 != x2 ? 1 : 0) * grid[y - 1][x2 - 1];
//                     int ans = dp[y][x1][x2];
//                     for (int d1 = -1; d1 <= 1; ++d1)
//                         for (int d2 = -1; d2 <= 1; ++d2) {
//                             ans = Math.max(ans, cur + dp[y + 1][x1 + d1][x2 + d2]);
//                             dp[y][x1][x2] = ans;
//                         }
//                 }
//         return dp[1][1][c];
//     }
// }

// O(c^2) Space
class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[c + 2][c + 2];
        for (int y = r; y >= 1; --y) {
            int[][] tmp = new int[c + 2][c + 2];
            for (int x1 = 1; x1 <= c; ++x1)
                for (int x2 = 1; x2 <= c; ++x2) {
                    int cur = grid[y - 1][x1 - 1] + (x1 != x2 ? 1 : 0) * grid[y - 1][x2 - 1];
                    for (int d1 = -1; d1 <= 1; ++d1)
                        for (int d2 = -1; d2 <= 1; ++d2) 
                            tmp[x1][x2] = Math.max(tmp[x1][x2], cur + dp[x1 + d1][x2 + d2]);
                }
            dp = tmp;
        }
        return dp[1][c];   
    }
}
