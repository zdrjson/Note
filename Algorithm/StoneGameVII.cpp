// // Top Down
// class Solution {
// public:
//     int stoneGameVII(vector<int>& A) {
//         const int n = A.size();
//         vector<vector<int>> cache(n, vector<int>(n, INT_MAX));
//         function<int(int, int, int)> dp = [&](int l, int r, int s) {
//             if (l >= r) return 0;
//             if (cache[l][r] == INT_MAX)
//                 cache[l][r] = max(s - A[r] - dp(l, r - 1, s - A[r]),
//                                   s - A[l] - dp(l + 1, r, s - A[l]));
//             return cache[l][r];
//         };
//         return dp(0, n - 1, accumulate(begin(A), end(A), 0));
//     }
// };

// Bottom-up
class Solution {
public:
    int stoneGameVII(vector<int>& A) {
        const int n = A.size();
        vector<int> s(n + 1);
        for (int i = 0; i < n; ++i) s[i + 1] = s[i] + A[i];
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int c = 2; c <= n; ++c)
            for (int l = 0, r = l + c - 1; r < n; ++l, ++r)
                dp[l][r] = max(s[r + 1] - s[l + 1] - dp[l + 1][r],
                               s[r] - s[l] - dp[l][r - 1]);
        return dp[0][n - 1];
    }
};
