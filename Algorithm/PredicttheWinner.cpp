// // Solution 1: Recursion
// // Time complexity: O(2^n)
// // Space complexity: O(n)
// class Solution {
// public:
//     bool PredictTheWinner(vector<int>& nums) {
//         return getScore(nums, 0, nums.size() - 1) >= 0;
//     }
// private:
//     // Max diff (my_score - op_score) of subarray nums[l] ~ nums[r].
//     int getScore(vector<int>& nums, int l, int r) {
//         if (l == r) return nums[l];
//         return max(nums[l] - getScore(nums, l + 1, r),
//                    nums[r] - getScore(nums, l, r - 1));
//     }
// };

// // Solution 2: Recursion + Memoization
// // Time complexity: O(n^2)
// // Space complexity: O(n) // 花花blog中写成O(n), 应该是O(n^2)
// class Solution {
// public:
//     bool PredictTheWinner(vector<int>& nums) {
//         m_ = vector<vector<int>>(nums.size(), vector<int>(nums.size(), INT_MIN));
//         return getScore(nums, 0, nums.size() - 1) >= 0;
//     }
// private:
//     vector<vector<int>> m_;
//     // Max diff (my_score - op_score) of subarray nums[l] ~ nums[r].
//     int getScore(vector<int>& nums, int l, int r) {
//         if (l == r) return nums[l];
//         if (m_[l][r] != INT_MIN) return m_[l][r];
//         m_[l][r] = max(nums[l] - getScore(nums, l + 1, r),
//                        nums[r] - getScore(nums, l, r - 1));
//         return m_[l][r];
//     }
// };

// DP version
class Solution {
public:
    bool PredictTheWinner(vector<int>& nums) {
        const int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n, INT_MIN));
        for (int i = 0; i < n; ++i)
            dp[i][i] = nums[i];
        for (int l = 2; l <= n; ++l)
            for (int i = 0; i <= n - l; ++i) {
                int j = i + l - 1;
                dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        return dp[0][n - 1] >= 0;
    }
};
