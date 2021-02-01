// Solution: DP
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int dp2 = 0;
        int dp1 = 0;
        for (int i = 0; i < nums.length; ++i) {
            int dp = Math.max(dp2 + nums[i], dp1);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}

// // Solution: DP
// // dp[i]: Max money after "visiting" house[i]
// // Time complexity: O(n)
// // Space complexity: O(n)
// class Solution {
//     public int rob(int[] nums) {
//         if (nums.length == 0) return 0;
//         int[] dp = new int[nums.length];
//         for (int i = 0; i < nums.length; ++i) 
//             dp[i] = Math.max((i > 1 ? dp[i - 2] : 0) + nums[i],
//                              (i > 0 ? dp[i - 1] : 0));
//         return dp[nums.length - 1];
//     }
// }

// // Solution: Recurison + Memorization
// // Time complexity: O(n)
// // Space complexity: O(n)
// class Solution {
//     private int[] m_;
//     public int rob(int[] nums) {
//         int n = nums.length;
//         m_ = new int[n];
//         Arrays.fill(m_, -1);
//         return rob(nums, n - 1);
//     }
//     private int rob(int[] nums, int i) {
//         if (i < 0) return 0;
//         if (m_[i] >= 0) return m_[i]; // 等于0是有可能的，当nums里面都是0的时候就是一种可能。
//         return m_[i] = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//     }
// }
