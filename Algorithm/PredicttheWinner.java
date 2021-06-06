// Solution: Recursion + Memoization With memory
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    private int[] m_;
    public boolean PredictTheWinner(int[] nums) {
        m_ = new int[nums.length * nums.length];
        return getScore(nums, 0, nums.length - 1) >= 0;
    }
    private int getScore(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int k = l * nums.length + r;
        if (m_[k] > 0) return m_[k];
        m_[k] = Math.max(nums[l] - getScore(nums, l + 1, r),
                         nums[r] - getScore(nums, l, r - 1));
        return m_[k];
    }
}

// // Solution: Recursion + Memorization No memory
// // Time complexity: O(2^n)
// // Space complexity: O(n)
// class Solution {
//     public boolean PredictTheWinner(int[] nums) {
//         return getScore(nums, 0, nums.length - 1) >= 0;
//     }
//     // Max diff (my_score - op_score) of subarray nums[l] ~ nums[r].
//     private int getScore(int[] nums, int l, int r) {
//         if (l == r) return nums[l];
//         return Math.max(nums[l] - getScore(nums, l + 1, r),
//                         nums[r] - getScore(nums, l, r - 1));
//     }
// }

// // Solution: DP
// // Time complexity: O(n^2)
// // Space complexity: O(n^2)
// class Solution {
//     public boolean PredictTheWinner(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n];
//         for (int[] d : dp)
//             Arrays.fill(d, Integer.MIN_VALUE);
//         for (int i = 0; i < n; ++i)
//             dp[i][i] = nums[i];
//         for (int l = 2; l <= n; ++l)
//             for (int i = 0; i <= n - l; ++i) {
//                 int j = i + l - 1;
//                 dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
//             }
//         return dp[0][n - 1] >= 0;
//     }
// }
