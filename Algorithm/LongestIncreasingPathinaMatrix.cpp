// // Solution1: DFS + Memorization
// // Time complexity: O(mn)
// // Space complexity: O(mn)
// class Solution {
// public:
//     int longestIncreasingPath(vector<vector<int>>& matrix) {
//         if (matrix.empty()) return 0;
//         m_ = matrix.size();
//         n_ = matrix[0].size();
//         dp_ = vector<vector<int>>(m_, vector<int>(n_, -1));
//         int ans = 0;
//         for (int y = 0; y < m_; ++y)
//             for (int x = 0; x < n_; ++x)
//                 ans = max(ans, dfs(matrix, x, y));
//         return ans;
//     }
// private:
//     int dfs(const vector<vector<int>>& mat, int x, int y) {
//         if (dp_[y][x] != -1) return dp_[y][x];
//         static int dirs[] = {0, -1, 0, 1, 0};
//         dp_[y][x] = 1;
//         for (int i = 0; i < 4; ++i) {
//             int tx = x + dirs[i];
//             int ty = y + dirs[i + 1];
//             if (tx < 0 || ty < 0 || tx >= n_ || ty >= m_ || mat[ty][tx] <= mat[y][x])
//                 continue;
//             dp_[y][x] = max(dp_[y][x], 1 + dfs(mat, tx, ty));
//         }
//         return dp_[y][x];
//     }
//     int m_;
//     int n_;
//     // dp[i][j]: max length start from (j, i)
//     vector<vector<int>> dp_;
// };

// Solution2: DP
// Time complexity: O(mn*log(mn))
// Space complexity: O(mn)
class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        if (matrix.empty()) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 1));
        int ans = 0;
        
        vector<pair<int, pair<int, int>>> cells;
        for (int y = 0; y < m; ++y)
            for (int x = 0; x < n; ++x)
                cells.push_back({matrix[y][x], {x, y}});
        sort(cells.rbegin(), cells.rend());
        
        vector<int> dirs {0, 1, 0, -1, 0};
        for (const auto& cell : cells) {
            int x = cell.second.first;
            int y = cell.second.second;
            for (int i = 0; i < 4; ++i) {
                int tx = x + dirs[i];
                int ty = y + dirs[i + 1];
                if (tx < 0 || tx >= n || ty < 0 || ty >= m) continue;
                if (matrix[ty][tx] <= matrix[y][x]) continue;
                dp[y][x] = max(dp[y][x], 1 + dp[ty][tx]);
            }
            ans = max(ans, dp[y][x]);
        }
        return ans;
    }
};
