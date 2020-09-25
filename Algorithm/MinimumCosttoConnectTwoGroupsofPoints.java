// Solution 1: Bitmask DP
// dp[i][s] := min cost to connect first i (1-based) points in group 1 and a set of points (represented by a bitmask s) in group2.
// ans = dp[m][1<< n - 1]
// dp[i][s | (1 << j)] := min(dp[i][s] + cost[i][j], dp[i-1][s] + cost[i][j])
// Time complexity: O(m*n*2^n)
// Space complexity: O(m*2^n)
class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        final int kInf = (int)1e9;
        final int m = cost.size();
        final int n = cost.get(0).size();
        // dp[i][s] := min cost to connect first i points in group1
        // and points (bitmask s) in group2.
        int[][] dp = new int[m + 1][1 << n];
        for (int[] r : dp)
            Arrays.fill(r, kInf);
        dp[0][0] = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                for (int s = 0; s < 1 << n; ++s)
                    dp[i + 1][s | (1 << j)] = Math.min(dp[i + 1][s | (1 << j)],
                                              Math.min(dp[i + 1][s] + cost.get(i).get(j),
                                                       dp[i][s] + cost.get(i).get(j)));
        return dp[m][(1 << n) - 1]; // 这里1 << n 外面一定要加上括号，否则运算顺序错误！！！
    }
}
