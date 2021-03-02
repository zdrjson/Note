// // Solution: DP / Knapsack
// // Pre-compute the costs of all possible combinations of toppings.
// // Time complexity: O(sum(toppings) * 2 * (m + n)) -O(10^6)
// // Space complexity: O(sum(toppings)) ~ O(10^5)
// class Solution {
//     public int closestCost(int[] bs, int[] ts, int target) {
//         int kMax = 0;
//         for (int t : ts)
//             kMax += 2 * t;
//         int min_diff = Integer.MAX_VALUE;
//         int ans = Integer.MAX_VALUE;
//         int[] dp = new int[kMax + 1];
//         dp[0] = 1;
//         for (int t : ts) {
//             for (int i = kMax; i >= 0; --i) {
//                 if (dp[i] == 0) continue;
//                 if (i + t <= kMax) dp[i + t] = 1;
//                 if (i + 2 * t <= kMax) dp[i + 2 * t] = 1;
//             }
//         }
//         for (int i = 0; i <= kMax; ++i) {
//             if (dp[i] == 0) continue;
//             for (int b : bs) {
//                 final int diff = Math.abs(b + i - target); // diff前面最好像花花C++代码加上final！！！
//                 if (diff < min_diff || diff == min_diff && b + i < target) { // 这里&&的两个条件可以不加括号。
//                     min_diff = diff;
//                     ans = b + i;
//                 }
//             }
//         }
//         return ans;
//     }
// }

// Solution 2: Combination
// Time complexity: O(3^m * n)
// Space complexity: O(m)
class Solution {
    private int m;
    private int min_diff;
    private int ans;
    private int[] bs;
    private int target;
    private int[] ts;
    public int closestCost(int[] bs, int[] ts, int target) {
        m = ts.length;
        min_diff = Integer.MAX_VALUE;
        ans = Integer.MAX_VALUE;
        this.bs = bs;
        this.target = target;
        this.ts = ts;
        dfs(0, 0);
        return ans;
    }
    private void dfs(int s, int cur) {
        if (s == m) {
            for (int b : bs) {
                final int total = b + cur;
                final int diff = Math.abs(total - target);
                if (diff < min_diff 
                    || diff == min_diff && total < target) {
                    min_diff = diff;
                    ans = total;
                }
            }
            return;
        }
        for (int i = s; i < m; ++i) {
            dfs(i + 1, cur);
            dfs(i + 1, cur + ts[i]);
            dfs(i + 1, cur + ts[i] * 2);
        }
    }
}
