// // Solution1: Backtracking
// class Solution {
// public:
//     bool canDistribute(vector<int>& nums, vector<int>& quantity) {
//         unordered_map<int, int> m;
//         for (int x : nums) ++m[x];
//         vector<int> cnt;
//         for (const auto& [x, c] : m) cnt.push_back(c);
        
//         const int q = quantity.size();
//         const int n = cnt.size();
//         function<bool(int)> dfs = [&](int d) {
//             if (d == q) return true;
//             for (int i = 0; i < n; ++i)
//                 if (cnt[i] >= quantity[d]) {
//                     cnt[i] -= quantity[d];
//                     if (dfs(d + 1)) return true;
//                     cnt[i] += quantity[d];
//                 }
//             return false;
//         };
        
//         sort(rbegin(cnt), rend(cnt));
//         sort(rbegin(quantity), rend(quantity));
        
//         return dfs(0);
//     }
// };

// // Solution 2: Bitmask + all subsets
// // Top-down
// class Solution {
// public:
//     bool canDistribute(vector<int>& nums, vector<int>& quantity) {
//         vector<int> cnt;
//         unordered_map<int, int> freq;
//         for (int x : nums) ++freq[x];
//         for (const auto& [x, f] : freq) cnt.push_back(f);
        
//         const int n = cnt.size();
//         const int m = quantity.size();
        
//         vector<vector<optional<bool>>> cache(1 << m, vector<optional<bool>>(n));
        
//         vector<int> sums(1 << m);
//         for (int mask = 0; mask < 1 << m; ++mask)
//             for (int i = 0; i < m; ++i)
//                 if (mask & (1 << i))
//                     sums[mask] += quantity[i];
        
//         function<bool(int, int)> dp = [&](int mask, int i) -> bool {
//             if (mask == 0) return true;
//             if (i == n) return false;
            
//             auto& ans = cache[mask][i];
            
//             if (ans.has_value()) return ans.value();
            
//             int cur = mask;
//             while (cur) {
//                 if (sums[cur] <= cnt[i] && dp(mask ^ cur, i + 1)) {
//                     ans = true;
//                     return true;
//                 }
//                 cur = (cur - 1) & mask;
//             }
            
//             ans = dp(mask, i + 1);
//             return ans.value();
//         };
        
//         return dp((1 << m) - 1, 0);
//     }
// };

// Bottom up
class Solution {
public:
    bool canDistribute(vector<int>& nums, vector<int>& quantity) {
        vector<int> cnt; 
        unordered_map<int, int> freq;
        for (int x : nums) ++freq[x];
        for (const auto&[x, f] : freq) cnt.push_back(f);
        
        const int n = cnt.size();
        const int m = quantity.size();

        vector<int> sums(1 << m);
        for (int mask = 0; mask < 1 << m; ++mask)
            for (int i = 0; i < m; ++i)
                if (mask & (1 << i))
                    sums[mask] += quantity[i];
        
        // dp[mask][i] := use first i types to satisfy mask customers.
        vector<vector<int>> dp(1 << m, vector<int>(n + 1));
        dp[0][0] = 1;
        for (int mask = 0; mask < 1 << m; ++mask)
            for (int i = 0; i < n; ++i) {
                dp[mask][i + 1] |= dp[mask][i];
                for (int cur = mask; cur; cur = (cur - 1) & mask)
                    if (sums[cur] <= cnt[i] && dp[mask ^ cur][i])
                        dp[mask][i + 1] = 1;
            }
        
        return dp[(1 << m) - 1][n];
    }
};
