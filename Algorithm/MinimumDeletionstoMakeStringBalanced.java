// Solution: DP
// dp[i][0] := min # of dels to make s[0:i] all 'a's;
// dp[i][1] := min # of dels to make s[0:i] ends with 0 or mode 'b's
// if s[i-1] == 'a':
// dp[i + 1][0] = dp[i][0], dp[i + 1][1] = min(dp[i + 1][0], dp[i][1] + 1)
// else:
// dp[i + 1][0] = dp[i][0] + 1, dp[i + 1][1] = dp[i][1]
// Time complexity: O(n)
// Space complexity: O(n) -> O(1)
class Solution {
    public int minimumDeletions(String s) {
        final int n = s.length();
        // dp[i][0] := min # of dels to make s[0:i] all 'a's;
        // dp[i][1] := min # of dels to make s[0:i] ends with 0+ 'b's
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'a') {
                dp[i + 1][0] = dp[i][0];
                dp[i + 1][1] = Math.min(dp[i + 1][0], dp[i][1] + 1);
            } else {
                dp[i + 1][0] = dp[i][0] + 1;
                dp[i + 1][1] = dp[i][1];
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}

// // Space complexity: O(1)
// class Solution {
//     public int minimumDeletions(String s) {
//         int a = 0, b = 0;
//         for (char c : s.toCharArray())
//             if (c == 'a') b = Math.min(a, b + 1);
//             else ++a;
//         return Math.min(a, b);
//     }
// }
