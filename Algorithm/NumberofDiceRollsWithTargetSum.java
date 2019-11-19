class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int kMod = (10^9) + 7;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= d; ++i) {
            for (int k = target; k >= 0; --k) {
                dp[k] = 0;
                for (int j = 1; j <= f && j <= k; ++j) {
                    dp[k] = (dp[k] + dp[k - j]) % kMod;
                }
            }
        }
        return dp[target];
    }
}