// // Solution: DP
// // Use dp[i][j] to represent the length of longest common sub-sequence of text1[0:i] and text2[0:i] 
// // dp[i][j] = dp[i - 1][j - 1] + 1 if text1[i - 1] == text2[j - 1] else max(dp[i][j - 1], dp[i - 1][j])
// // Time complexity: O(mn)
// // Space complexity: O(mn) -> O(n)
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i < m; ++i) 
//             for (int j = 0; j < n; ++j) {
//                 if (text1.charAt(i) == text2.charAt(j)) 
//                     dp[i + 1][j + 1] = dp[i][j] + 1;
//                 else 
//                     dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
//             }
//         return dp[m][n];
//     }
// }

// V2
// Space complexity: O(n)
// 不是很懂
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; ++i) {
            int prev = 0; // dp[i][j]
            for (int j = 0; j < n; ++j) {
                int cur = dp[j + 1]; // dp[i][j + 1]
                if (text1.charAt(i) == text2.charAt(j))
                    // dp[i + 1][j + 1] = dp[i][j] + 1
                    dp[j + 1] = prev + 1;
                else
                    // dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j])
                    dp[j + 1] = Math.max(cur, dp[j]);
                prev = cur;
            }
        }
        return dp[n]; // dp[m][n]
    }
}

// // V3
// // Space complexity: O(n)
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         int[] dp1 = new int[n + 1];
//         int[] dp2 = new int[n + 1];
//         for (int i = 0; i < m; ++i) {
//             for (int j = 0; j < n; ++j) 
//                 if (text1.charAt(i) == text2.charAt(j))
//                     dp2[j + 1] = dp1[j] + 1;
//                 else
//                     dp2[j + 1] = Math.max(dp1[j + 1], dp2[j]);
//             int[] tmp = dp1;
//             dp1 = dp2;
//             dp2 = tmp;
//         }
//         return dp1[n];
//     }
// }
