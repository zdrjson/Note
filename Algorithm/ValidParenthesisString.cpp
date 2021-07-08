// // Solution: DP Top-down O(n^3)
// // Time complexity: O(n^3)
// // Space complexity: O(n^2)
// class Solution {
// public:
//     bool checkValidString(string s) {
//         int l = s.length();
//         m_ = vector<vector<int>>(l, vector<int>(l, -1));
//         return isValid(s, 0, l - 1);
//     }
// private:
//     vector<vector<int>> m_;
//     bool isValid(const string& s, int i, int j) {
//         if (i > j) return true;
//         if (m_[i][j] >= 0) return m_[i][j];
        
//         if (i == j) return m_[i][j] = (s[i] == '*');
        
//         if ((s[i] == '(' || s[i] == '*')
//           &&(s[j] == ')' || s[j] == '*')
//           && isValid(s, i + 1, j - 1))
//             return m_[i][j] = 1;
        
//         for (int p = i; p < j; ++p)
//             if (isValid(s, i, p) && isValid(s, p + 1, j))
//                 return m_[i][j] = 1;
        
//         return m_[i][j] = 0;
//     }
// };

// // Solution: DP Bottom-up 
// // Time complexity: O(n^3)
// // Space complexity: O(n^2)
// class Solution {
// public:
//     bool checkValidString(string s) {
//         int l = s.length();
//         if (l == 0) return true;
//         vector<vector<int>> dp(l, vector<int>(l, 0));
//         for (int i = 0; i < l; ++i)
//             if (s[i] == '*') dp[i][i] = 1;
//         for (int len = 2; len <= l; ++len)
//             for (int i = 0; i <= l - len; ++i) {
//                 int j = i + len - 1;
//                 // (...), *...), (...*, *...*
//                 if ((s[i] == '(' || s[i] == '*')
//                   &&(s[j] == ')' || s[j] == '*'))
//                     if (len == 2 || dp[i + 1][j - 1]) {
//                         dp[i][j] = 1;
//                         continue;
//                     }
                
//                 for (int k = i; k < j; ++k)
//                     if (dp[i][k] && dp[k + 1][j]) {
//                         dp[i][j] = 1;
//                         break;
//                     }
//             }
//         return dp[0][l - 1];
//     }
// };

// Counting: 
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
public:
    bool checkValidString(string s) {
        int min_op = 0; // min_op表示强制需要匹配的左括号。
        int max_op = 0; // max_op表示可选匹配的左括号。
        
        for (char c : s) {
            if (c == '(') ++min_op; else --min_op;
            if (c != ')') ++max_op; else --max_op;
            if (max_op < 0) return false;
            min_op = max(0, min_op);
        }
        
        return min_op == 0;
    }
};
