// Solution: DP
// dp[i] := min cost to cover the i-th day
// dp[0] = 0
// dp[i] = min(dp[i - 1] + costs[0], dp[i - 7] + costs[1], dp[i - 30] + costs[2])
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] req = new int[days[days.length - 1] + 1];
        int[] dp = new int[days[days.length - 1] + 1];
        for (int day : days) req[day] = 1;
        dp[0] = 0;
        for (int i = 1; i < dp.length; ++i) {
            if (req[i] != 1) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
        }
        return dp[dp.length - 1];
    }
}
