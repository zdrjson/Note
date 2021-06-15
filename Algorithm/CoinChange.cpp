// // Solution1: DP
// class Solution {
// public:
//     int coinChange(vector<int>& coins, int amount) {
//         vector<int> dp(amount + 1, INT_MAX);
//         dp[0] = 0;
//         for (auto coin : coins) {
//             for (int i = amount - coin; i >= 0; --i)
//                 if (dp[i] != INT_MAX)
//                     for (int k = 1; k * coin + i <= amount; ++k)
//                         dp[i + k * coin] = min(dp[i + k * coin], dp[i] + k);
//         }
        
//         return dp[amount] == INT_MAX ? -1 : dp[amount];
//     }
// };

// // Solution2: DP
// class Solution {
// public:
//     int coinChange(vector<int>& coins, int amount) {
//         // dp[i] = min coins to make up to amount i
//         vector<int> dp(amount + 1, INT_MAX);
//         dp[0] = 0;
//         for (int coin : coins) {
//             for (int i = coin; i <= amount; ++i)
//                 if (dp[i - coin] != INT_MAX)
//                     dp[i] = min(dp[i], dp[i - coin] + 1);
//         }
    
//         return dp[amount] == INT_MAX ? -1 : dp[amount];
//     }
// };

// Solution3: DFS
// 现在TLE了。
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        // Sort coins in desending order
        std::sort(coins.rbegin(), coins.rend());
        int ans = INT_MAX;
        coinChange(coins, 0, amount, 0, ans);
        return ans == INT_MAX ? -1 : ans;
    }
private:
    void coinChange(const vector<int>& coins,
                    int s, int amount, int count, int& ans) {
        if (amount == 0) {
            ans = min(ans, count);
            return;
        }
        
        if (s == coins.size()) return;
        
        const int coin = coins[s];
        for (int k = amount / coin; k >= 0 && count + k < ans; --k)
            coinChange(coins, s + 1, amount - k * coin, count + k, ans);
    }
};
