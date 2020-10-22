// Solution 1: Brute Force + Diameter of tree
// Try all subtrees and find the diameter of that subtree (longest distance between any node)
// Time complexity: O(2^n * n)
// Space complexity: O(n)
class Solution {
public:
    vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges, int last = -1) {
        vector<vector<int>> g(n);
        for (const auto& e : edges)
            g[e[0] - 1].push_back(e[1] - 1), g[e[1] - 1].push_back(e[0] - 1);
        
        vector<int> seen(n, -1), seen2;
        queue<int> q;
        
        auto bfs = [&](int start, vector<int>& seen) -> pair<int, int> {
            q.push(start);
            seen[start] = 1;
            int count = 0, dist = -1;
            while (!q.empty()) {
                int s = q.size();
                while (s--) {
                    last = q.front(); q.pop();
                    ++count;
                    for (int v : g[last])
                        if (seen[v] != -1 && !seen[v]++) q.push(v);
                }
                ++dist;
            }
            return {dist, count};
        };
        
        vector<int> ans(n - 1);
        for (int s = 0; s < 1 << n; ++s) {
            if (__builtin_popcount(s) <= 1) continue;
            fill(begin(seen), end(seen), -1);
            for (int i = 0; i < n; ++i) if (s & (1 << i)) seen[i] = 0;
            seen2 = seen;
            const int start = 31 - __builtin_clz(s & (s - 1));
            if (bfs(start, seen).second != __builtin_popcount(s)) continue;
            ++ans[bfs(last, seen2).first - 1];
        }
        return ans;
    }
};

// // Solution 2: DP on Trees
// // dp[i][k][d] := # of subtrees rooted at i with tree diameter of d and the distance from i to the fartest node is k.
// // Time complexity: O(n^5)
// // Space complexity: O(n^3)
// class Solution {
// public:
//     vector<int> countSubgraphsForEachDiameter(int n, vector<vector<int>>& edges) {
//         vector<vector<int>> g(n);
//         for (const auto& e : edges) {
//             g[e[0] - 1].push_back(e[1] - 1);
//             g[e[1] - 1].push_back(e[0] - 1);
//         }
//         vector<vector<vector<int>>> dp(n);
//         vector<int> sizes(n);
//         function<void(int, int)> dfs = [&](int u, int p) {
//             if (!dp[u].empty()) return;
//             dp[u] = vector<vector<int>>(n, vector<int>(n));
//             dp[u][0][0] = 1;
//             sizes[u] = 1;
//             for (int v : g[u]) {
//                 if (v == p) continue;
//                 dfs(v, u);
//                 vector<vector<int>> dpu(dp[u]);
//                 for (int d1 = 0; d1 < sizes[u]; ++d1)
//                     for (int k1 = 0; k1 <= d1; ++k1) {
//                         if (!dp[u][k1][d1]) continue;
//                         for (int d2 = 0; d2 < sizes[v]; ++d2)
//                             for (int k2 = 0; k2 <= d2; ++k2) {
//                                 const int d = max({d1, d2, k1 + k2 + 1});
//                                 const int k = max(k1, k2 + 1);
//                                 dpu[k][d] += dp[u][k1][d1] * dp[v][k2][d2];
//                             }
//                     }
//                 swap(dpu, dp[u]);
//                 sizes[u] += sizes[v];
//             }
//         };
//         vector<int> ans(n - 1);
//         dfs(0, -1);
//         for (int i = 0; i < n; ++i)
//             for (int k = 0; k < n; ++k)
//                 for (int d = 1; d < n; ++d)
//                     ans[d - 1] += dp[i][k][d];
//         return ans;
//     }
// };
