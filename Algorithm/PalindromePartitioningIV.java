// Solution: DP
// dp[i][j] := whether s[i]~s[j] is a palindrome
// dp[i][j] = s[i] == s[j]and dp[i+1][j-1]
// ans = any(dp[0][i-1] and dp[i][j] and dp[j][n-1]) for j in range(i, n - 1) for i in range(1, n)
// Time complexity: O(n^2)
// Space complexity: O(n^2)
class Solution {
    public boolean checkPartitioning(String s) {
        final int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] r : dp)
            Arrays.fill(r, 1); // 默认要设置成是回文字符串。
        for (int l = 2; l <= n; ++l)
            for (int i = 0, j = i + l - 1; j < n; ++i, ++j)
                dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1] == 1) ? 1 : 0;
        
        for (int i = 1; i < n; ++i)
            for (int j = i; j + 1 < n; ++j)
                if (dp[0][i - 1] == 1 && dp[i][j] == 1 && dp[j + 1][n - 1] == 1)
                    return true;
        return false;
    }
}
