// Solution: DP
// // Use dp[i][j] to represent the length of longest common sub-sequence of text1[0:i] and text2[0:j]
// // dp[i][j] = dp[i - 1][j - 1] + 1 if text1[i - 1] == text2[j - 1] else max(dp[i][j - 1], dp[i - 1][j])
// // Time complexity: O(mn)
// // Space complexity: O(mn) -> O(n)
// class Solution {
// public:
//     int longestCommonSubsequence(string text1, string text2) {
//         int m = text1.length();
//         int n = text2.length();
//         vector<vector<int>> dp(m + 1, vector<int>(n + 1));
//         for (int i = 0; i < m; ++i)
//             for (int j = 0; j < n; ++j)
//                 if (text1[i] == text2[j])
//                     dp[i + 1][j + 1] = dp[i][j] + 1;
//                 else
//                     dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
//         return dp[m][n];
//     }
// };

// // v2
// class Solution {
// public:
//     int longestCommonSubsequence(string text1, string text2) {
//         int m = text1.length();
//         int n = text2.length();
//         vector<int> dp(n + 1);
//         for (int i = 0; i < m; ++i) {
//             int prev = 0; // dp[i][j]
//             for (int j = 0; j < n; ++j) {
//                 int curr = dp[j + 1];
//                 if (text1[i] == text2[j])
//                     // dp[i + 1][j + 1] = dp[i][j] + 1;
//                     dp[j + 1] = prev + 1;
//                 else 
//                     // dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j])
//                     dp[j + 1] = max(curr, dp[j]);
//                 prev = curr;
//             }
//         }
//         return dp[n]; // dp[m][n]
//     }
// };

// v3
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int m = text1.length();
        int n = text2.length();
        vector<int> dp1(n + 1);
        vector<int> dp2(n + 1);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                if (text1[i] == text2[j])
                    dp2[j + 1] = dp1[j] + 1;
                else
                    dp2[j + 1] = max(dp1[j + 1], dp2[j]);
            swap(dp1, dp2);
        }
        return dp1[n];
    }
};
