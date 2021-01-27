class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        vector<int> m(26);
        for (char c : allowed) m[c - 'a'] = 1;
        int ans = 0;
        for (const string& w : words)
            ans += all_of(begin(w), end(w), [&m](char c) { return m[c - 'a']; });
        return ans;
    }
};
