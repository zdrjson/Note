class Solution {
public:
    string reverseWords(string s) {
        int index = 0;
        for (int i = 0; i <= s.length(); ++i) {
            if (i == s.length() || s[i] == ' ') {
                std::reverse(s.begin() + index, s.begin() + i);
                index = i + 1;
            }
        }
        return s;
    }
};
