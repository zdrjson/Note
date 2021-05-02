class Solution {
public:
    int longestBeautifulSubstring(string word) {
        const int n = word.length();
        int ans = 0;
        char p = 'a' - 1;
        for (int i = 0, vowels = 0, l = 0; i < n; ++i) {
            if (word[i] < p) {
                vowels = (word[i] == 'a');
                l = i;
            } else if (word[i] > p) {
                ++vowels;
            }
            if (vowels == 5)
                ans = max(ans, i - l + 1);
            p = word[i];
        }
        return ans;
    }
};
