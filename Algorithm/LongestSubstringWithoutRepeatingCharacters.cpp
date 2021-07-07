class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        const int n = s.length();
        int ans = 0;
        vector<int> idx(128, -1);
        for (int i = 0, j = 0; j < n; ++j) {
            i = max(i, idx[s[j]] + 1);
            ans = max(ans, j - i + 1);
            idx[s[j]] = j;
        }
        return ans;
    }
};
