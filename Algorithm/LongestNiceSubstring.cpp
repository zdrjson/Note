// // Solution: Brute Force
// // Time complexity: O(n^3)
// // Space complexity: O(1)
// class Solution {
// public:
//     string longestNiceSubstring(string_view s) { // 这里我们自己手动把入参的类型由string改为了string_view。
//         const int n = s.length();
//         auto isNice = [](string_view s) {
//             vector<int> u(26), l(26);
//             for (int c : s)
//                 if (isupper(c)) u[c - 'A'] = 1;
//                 else l[c - 'a'] = 1;
//             return u == l;
//         };
//         string_view ans;
//         for (int i = 0; i < n; ++i)
//             for (int j = i + 1; j < n; ++j) {
//                 string_view ss = s.substr(i, j - i + 1);
//                 if (isNice(ss) && ss.length() > ans.length())
//                     ans = ss;
//             }
//         return string(ans);
//     }
// };

// Optimized 1:
// Time complexity: O(n^2*26)
// Space complexity: O(1)
class Solution {
public:
    string longestNiceSubstring(string_view s) { // 注意这里我们自己手动把入参的类型由string改为了string_view。
        const int n = s.length();
        string_view ans;
        for (int i = 0; i < n; ++i) {
            vector<int> u(26), l(26);
            for (int j = i; j < n; ++j) {
                const char c = s[j];
                if (isupper(c)) u[c - 'A'] = 1;
                else l[c - 'a'] = 1;
                if (u == l && j - i + 1 > ans.length())
                    ans = s.substr(i, j - i + 1);
            }
        }
        return string(ans);
    }
};
