// // Solution: DP
// // dp(i, j) := max score we can get with nums[i~j] left.
// // k = n - (j - i + 1)
// // dp(i, j) = max(dp(i + 1, j) + nums[i] * multipliers[k], dp(i, j-1) + nums[j] * multipliers[k])
// // Time complexity: O(m*m)
// // Space complexity: O(m*m)
// // Top-Down
// // 这题Top-Down比较好想，好理解一点，写代码顺序，边界调节也比Bottom-UP少
// class Solution {
//     private int m;
//     private int n;
//     private int[][] cache;
//     private int[] nums;
//     private int[] multipliers;
//     public int maximumScore(int[] nums, int[] multipliers) {
//         m = multipliers.length;
//         n = nums.length;
//         cache = new int[m][m];
//         this.nums = nums;
//         this.multipliers = multipliers;
//         for (int[] d : cache)
//             Arrays.fill(d, Integer.MIN_VALUE);
//         return dp(0, n - 1);
//     }
//     private int dp(int i, int j) {
//         final int k = n - (j - i + 1);
//         if (k == m) return 0;
//         int ans = cache[i][k];
//         if (ans != Integer.MIN_VALUE) return ans;
//         ans = Math.max(dp(i + 1, j) + nums[i] * multipliers[k],
//                        dp(i, j - 1) + nums[j] * multipliers[k]);
//         return cache[i][k] = ans;
//     }
// }

// Bottom-UP
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        final int m = multipliers.length;
        final int n = nums.length;
        // dp[i][j] := max score of using first i elements and last j elements.
        int[][] dp = new int[m + 1][m + 1];
        for (int k = 1; k <= m; ++k)
            for (int i = 0, j = k - i; i <= k; ++i, --j)
                dp[i][j] = Math.max((i != 0 ? dp[i - 1][j] + nums[i - 1] * multipliers[k - 1] : Integer.MIN_VALUE),
                                    (j != 0 ? dp[i][j - 1] + nums[n - j] * multipliers[k - 1] : Integer.MIN_VALUE));
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= m; ++i)
            ans = Math.max(ans, dp[i][m - i]);
        return ans;
    }
}
