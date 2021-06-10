class Solution {
public:
    int countSegments(string s) {
        if (s.empty()) return 0;
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s[i] == ' ') ++i;
            if (i == s.length()) break;
            while (i < s.length() && s[i] != ' ') ++i;
            ++ans;
            ++i;
        }
        return ans;
    }
};
