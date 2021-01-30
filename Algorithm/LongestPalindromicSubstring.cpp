// Solution: DP
// Try all possible i and find the longest palindromic string whose center is i (odd case) and i / i + 1 (even case).
// Time complexity: O(n^2)
// Space complexity: O(1)
class Solution {
public:
    string longestPalindrome(string s) {
        const int n = s.length();
        auto getLen = [&](int l, int r) {
            while (l >= 0 && r < n
                   && s[l] == s[r]) {
                --l;
                ++r;
            }
            return r - l - 1;
        };
        int len = 0;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            int cur = max(getLen(i, i),
                          getLen(i, i + 1));
            if (cur > len) {
                len = cur;
                start = i - (len - 1) / 2;
            }
        }
        return s.substr(start, len);
    }
};
