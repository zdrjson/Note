// // Solution: DP / Knapsack
// class Solution {
// public:
//     int closestCost(vector<int>& bs, vector<int>& ts, int target) {
//         const int kMax = 2 * accumulate(begin(ts), end(ts), 0);
//         int min_diff = INT_MAX;
//         int ans = INT_MAX;
//         vector<int> dp(kMax + 1);
//         dp[0] = 1;
//         for (int t : ts) {
//             for (int i = kMax; i >= 0; --i) {
//                 if (!dp[i]) continue;
//                 if (i + t <= kMax) dp[i + t] = 1;
//                 if (i + 2 * t <= kMax) dp[i + 2 * t] = 1;
//             }
//         }
//         for (int i = 0; i <= kMax; ++i) {
//             if (!dp[i]) continue;
//             for (int b : bs) {
//                 const int diff = abs(b + i - target);
//                 if (diff < min_diff || diff == min_diff && b + i < ans) {
//                     min_diff = diff;
//                     ans = b + i;
//                 }
//             }
//         }
//         return ans;
//     }
// };

// Solution 2: DFS
class Solution {
public:
    int closestCost(vector<int>& bs, vector<int>& ts, int target) {
        const int m = ts.size();
        int min_diff = INT_MAX;
        int ans = INT_MAX;
        function<void(int, int)> dfs = [&](int s, int cur) {
            if (s == m) {
                for (int b : bs) {
                    const int total = b + cur;
                    const int diff = abs(total - target);
                    if (diff < min_diff
                        || min_diff == diff && total < ans) {
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
        };
        dfs(0, 0);
        return ans;
    };
};
