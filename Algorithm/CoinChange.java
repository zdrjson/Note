// Solution3: DFS
// Time complexity: O(amount^n/(coin_0*coin_1*...*coin_n))
// Space complexity: O(n)
// 现在TLE了。
class Solution {
    private int ans;
    public int coinChange(int[] coins, int amount) {
        // Sort coins in desending order
        // Arrays.sort(coins, Collections.reverseOrder());  注释的方法LeetCode编译不过 这里要降序排列
        // Arrays.sort(coins);
        // int n = coins.length;
        // int[] reverseCoins = new int[n];
        // for (int i = n - 1; i >= 0; --i) {
        //     reverseCoins[(n - 1) - i] = coins[i];
        // }
        Arrays.setAll(coins, i -> ~coins[i]); // 这里和上面写的reverseCoins效果一样，都是降序排列。
        Arrays.sort(coins);
        Arrays.setAll(coins, i -> ~coins[i]);
        ans = Integer.MAX_VALUE;
        coinChange(coins, 0, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private void coinChange(int[] coins, int s, int amount, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        
        if (s == coins.length) return;
        int coin = coins[s];
        
        // Last element
        // if (s == coins.length) {
        //     if (amount % coin == 0)
        //         ans = Math.min(ans, count + amount / coin);
        // } else {
            for (int k = amount / coin; k >= 0 && k + count < ans; --k)
                coinChange(coins, s + 1, amount - k * coin, count + k);
        // }
    }
}

// // Solution2: DP
// // Time complexity: O(n*amount)
// // Space complexity: O(amount)
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, Integer.MAX_VALUE); // 这里Integer.MAX_VALUE也可以用amount + 1代替 因为最多用amount个数量的硬币。
//         dp[0] = 0;
//         for (int coin : coins) {
//             for (int i = coin; i <= amount; ++i) {
//                 if (dp[i - coin] != Integer.MAX_VALUE) {
//                     dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                 }
//             }
//         }
//         return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
//     }
// }

// // Solution1: DP
// // Time complexity: O(n*amount^2)
// // Space complexity: O(amount)
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, Integer.MAX_VALUE);
//         dp[0] = 0;
//         for (int coin : coins) {
//             for (int i = amount - coin; i >= 0; --i) { // 对一个硬币，循环上一次构成的合法的值。
//                 if (dp[i] != Integer.MAX_VALUE) {
//                     for (int k = 1; k * coin + i <= amount; ++k) {
//                         dp[i + k * coin] = Math.min(dp[i + k * coin], dp[i] + k);
//                     }
//                 }
//             }
//         }
//         return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
//     }
// }
