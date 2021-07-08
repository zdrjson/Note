// // Solution: Counting
// // Time complexity: O(n)
// // Space complexity: O(1)
// class Solution {
//     public boolean checkValidString(String s) {
//         int min_op = 0; // min_op表示强制需要匹配的左括号。
//         int max_op = 0; // max_op表示可选的左括号。
        
//         for (int i = 0; i < s.length(); ++i) {
//             if (s.charAt(i) == '(') ++min_op; else --min_op;
//             if (s.charAt(i) != ')') ++max_op; else --max_op;
//             if (max_op < 0) return false;
//             min_op = Math.max(min_op, 0);
//         }
        
//         return min_op == 0;
//     }
// }

// // Solution: DP Bottom-up using boolean array
// // Time complexity: O(n^3)
// // Space complexity: O(n^2)
// class Solution {
//     public boolean checkValidString(String s) {
//         int l = s.length();
//         if (l == 0) return true;
//         boolean[][] dp = new boolean[l][l];
        
//         char[] ss = s.toCharArray();
//         for (int i = 0; i < l; ++i)
//             if (ss[i] == '*') dp[i][i] = true;
//         for (int len = 2; len <= l; ++len)
//             for (int i = 0; i <= l - len; ++i) {
//                 int j = i + len - 1;
                
//                 if ((ss[i] == '*' || ss[i] == '(')
//                   &&(ss[j] == '*' || ss[j] == ')')) {
//                     if (len == 2 || dp[i + 1][j - 1]) {
//                         dp[i][j] = true;
//                         continue;
//                     }
//                 }
                
//                 for (int k = i; k < j; ++k)
//                     if (dp[i][k] && dp[k + 1][j]) {
//                         dp[i][j] = true;
//                         break;
//                     }
//             }
//          return dp[0][l - 1];    
//     }
// }

// // Solution: DP Bottom-up
// // Time complexity: O(n^3)
// // Space complexity: O(n^2)
// class Solution {
//     public boolean checkValidString(String s) {
//         int l = s.length();
//         if (l == 0) return true;
//         int[][] dp = new int[l][l];
//         for (int i = 0; i < l; ++i)
//             if (s.charAt(i) == '*') dp[i][i] = 1;
//         for (int len = 2; len <= l; ++len)
//             for (int i = 0; i <= l - len; ++i) {
//                 int j = i + len - 1;
//                 // (...), *...), (...*, *...*
//                 if ((s.charAt(i) == '(' || s.charAt(i) == '*') 
//                   &&(s.charAt(j) == ')' || s.charAt(j) == '*'))
//                     if (len == 2 || dp[i + 1][j - 1] == 1) {
//                         dp[i][j] = 1;
//                         continue;
//                     }
                
//                 for (int k = i; k < j; ++k)
//                     if (dp[i][k] == 1 && dp[k + 1][j] == 1) {
//                         dp[i][j] = 1;
//                         break;
//                     }
//             }
//         return dp[0][l - 1] == 1 ? true : false;   
//     }
// }

// Solution: DP Top-down
// Time complexity: O(n^3)
// Space complexity: O(n^2)
class Solution {
    private int[][] m_;
    public boolean checkValidString(String s) {
        int l = s.length();
        m_ = new int[l][l];
        for (int[] j : m_)
            Arrays.fill(j, -1);
        return isValid(s, 0, l - 1);
    }
    private boolean isValid(String s, int i, int j) {
        if (i > j) return true;
        if (m_[i][j] != -1) return m_[i][j] == 1 ? true : false;
        
        if (i == j)  {
            m_[i][j] = (s.charAt(i) == '*') ? 1 : 0;
            return m_[i][j] == 1 ? true : false;
        }
        
        if ((s.charAt(i) == '(' || s.charAt(i) == '*')
          &&(s.charAt(j) == ')' || s.charAt(j) == '*')
          && isValid(s, i + 1, j - 1)) {
             m_[i][j] = 1;
             return true;   
        }
        
        for (int p = i; p < j; ++p)
            if (isValid(s, i, p) && isValid(s, p + 1, j)) {
                m_[i][j] = 1;
                return true;
            }
               
        
         m_[i][j] = 0;
         return false;
    }
}
