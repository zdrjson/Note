// // Solution: DP
// // Time complexity: O(n^2)
// // Space complexity: O(n^2)
// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         final int n = s.length();
//         int[][] dp = new int[n][n];
//         for (int l = 1; l <= n; ++l)
//             for (int i = 0; i <= n - l; ++i) {
//                 int j = i + l - 1;
//                 if (i == j) {
//                     dp[i][j] = 1;
//                     continue;
//                 }
//                 dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//                 if (s.charAt(i) == s.charAt(j))
//                     dp[i][j] = dp[i + 1][j - 1] + 2;
//             }
//         return dp[0][n - 1];
//     }
// }

// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    public int longestPalindromeSubseq(String s) {
        final int n = s.length();
        int[] dp0 = new int[n]; // sols of len = l
        int[] dp1 = new int[n]; // sols of len = l - 1
        int[] dp2 = new int[n]; // sols of len = l - 2
        for (int l = 1; l <= n; ++l) {
            for (int i = 0; i <= n - l; ++i) {
                int j = i + l - 1;
                if (i == j) {
                    dp0[i] = 1;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp0[i] = dp2[i + 1] + 2;
                } else {
                    dp0[i] = Math.max(dp1[i + 1], dp1[i]);
                }
            }
            int[] tmp = dp2;
            dp2 = dp1;
            dp1 = dp0;
            dp0 = tmp;
        }
        return dp1[0];
    }
}
