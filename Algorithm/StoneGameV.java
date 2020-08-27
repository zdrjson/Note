// Solution: Range DP + Prefix Sum
// dp[l][r] := max store Alice can get from range [l, r]
// sum_l = sum(l, k), sum_r = sum(k + 1, r)
// dp[l][r] = max{
// dp[l][k] + sum_l if sum_l < sum_r
// dp[k+1][r] + sum_r if sum_r < sum_l
// max(dp[l][k], dp[k+1][r])) + sum_l if sum_l == sum_r)
// } for k in [l,r)
// Time complexity: O(n^3)
// Space complexity: O(n^2)
class Solution {
    private int n;
    private int[] sums;
    private int[][] cache;
    public int stoneGameV(int[] stoneValue) {
        n = stoneValue.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + stoneValue[i];
        cache = new int[n][n];
        for (int[] r : cache)
            Arrays.fill(r, -1);
        return dp(0, n - 1);
    }
    // max value alice can get from range [l, r]
    private int dp(int l, int r) {
        if (l == r) return 0;
        int ans = cache[l][r];
        if (ans != -1) return ans;
        for (int k = l; k < r; ++k) {
            // left: [l, k], right: [k + 1, r]
            int sum_l = sums[k + 1] - sums[l];
            int sum_r = sums[r + 1] - sums[k + 1];
            if (sum_l > sum_r) 
                ans = Math.max(ans, sum_r + dp(k + 1, r));
            else if (sum_l < sum_r)
                ans = Math.max(ans, sum_l + dp(l, k));
            else 
                ans = Math.max(ans, sum_l + Math.max(dp(l, k), dp(k + 1, r)));
        }
        return cache[l][r] = ans;
    }
}
