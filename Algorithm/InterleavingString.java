// // Solution: DP
// // Subproblems : whether s3[0:i+j] can be formed by interleaving s1[0:i] and s2[0:j].
// // Time complexity: O(mn)
// // Space compexity: O(mn)
// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         int l1 = s1.length();
//         int l2 = s2.length();
//         int l3 = s3.length();
//         if (l1 + l2 != l3) return false;
//         // dp[i][j]: whether s3[0:i+j] is a interleav of s1[0:i] and s2[0:j]
//         boolean[][] dp = new boolean[l1 + 1][l2 + 1];
//         dp[0][0] = true;
//         for (int i = 0; i <= l1; ++i)
//             for (int j = 0; j <= l2; ++j) {
//                 if (i > 0) dp[i][j] |= dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
//                 if (j > 0) dp[i][j] |= dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
//             }
//         return dp[l1][l2];
//     }
// }

// Recursion + Memorization
class Solution {
    // dp[i][j]: whether s3[0:i+j] is a interleav of s1[0:i] and s2[0:j]
    private int[][] m_;
    public boolean isInterleave(String s1, String s2, String s3) {
        m_ = new int[s1.length() + 1][s2.length() + 1];
        for (int[] r : m_) Arrays.fill(r, Integer.MIN_VALUE);
        return dp(s1, s1.length(), s2, s2.length(), s3, s3.length());
    }
    private boolean dp(String s1, int l1, String s2, int l2, String s3, int l3) {
        if (l1 + l2 != l3) return false;
        if (l1 == 0 && l2 == 0) return true;
        if (m_[l1][l2] != Integer.MIN_VALUE) return m_[l1][l2] == 1 ? true : false;
        if (l1 > 0 && s1.charAt(l1 - 1) == s3.charAt(l3 - 1) && dp(s1, l1 - 1, s2, l2, s3, l3 - 1)
          ||l2 > 0 && s2.charAt(l2 - 1) == s3.charAt(l3 - 1) && dp(s1, l1, s2, l2 - 1, s3, l3 - 1))
            m_[l1][l2] = 1;
        else
            m_[l1][l2] = 0;
        return m_[l1][l2] == 1 ? true : false;
    }
}
