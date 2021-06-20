// // Solution: DP
// // Time complexity: O(n^2)
// // Space complexity: O(n^2)
// class Solution {
// public:
//     int longestPalindromeSubseq(string s) {
//         const int n = s.length();
//         vector<vector<int>> dp(n, vector<int>(n, 0));
//         for (int l = 1; l <= n; ++l)
//             for (int i = 0; i <= n - l; ++i) {
//                 int j = i + l - 1;
//                 if (i == j) {
//                     dp[i][j] = 1;
//                     continue;
//                 }
//                 dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
//                 if (s[i] == s[j])
//                     dp[i][j] = dp[i + 1][j - 1] + 2;
//             }
//         return dp[0][n - 1];
//     }
// };

// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
public:
    int longestPalindromeSubseq(string s) {
        const int n = s.length();
        vector<int> dp0(n); // sols of len = 1
        vector<int> dp1(n); // sols of len = l - 1
        vector<int> dp2(n); // sols of len = l - 2
        for (int l = 1; l <= n; ++l) {
            for (int i = 0; i <= n - l; ++i) {
                int j = i + l - 1;
                if (i == j) {
                    dp0[i] = 1;
                    continue;
                }
                if (s[i] == s[j])
                    dp0[i] = dp2[i + 1] + 2;
                else
                    dp0[i] = max(dp1[i + 1], dp1[i]);
            }
            dp0.swap(dp1);
            dp2.swap(dp0);
        }
        return dp1[0];
    }
};
