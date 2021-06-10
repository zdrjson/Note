class Solution {
public:
    string licenseKeyFormatting(string S, int K) {
        string s;
        for (char c : S)
            if (c != '-') s.push_back(toupper(c));
        int first = s.length() % K;
        string ans = s.substr(0, first);
        for (int i = 0; i < s.length() - first; ++i) {
            if (i % K == 0 && (i + first)) ans += '-';
            ans.push_back(s[i + first]);
        }
        return ans;
    }
};
