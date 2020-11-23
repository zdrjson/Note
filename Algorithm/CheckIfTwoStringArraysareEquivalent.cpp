// class Solution {
// public:
//     bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
//         string s1, s2;
//         for (const string& w1 : word1) s1 += w1;
//         for (const string& w2 : word2) s2 += w2;
//         return s1 == s2;
//     }
// };

class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        int i1 = 0, j1 = 0;
        int i2 = 0, j2 = 0;
        while (i1 < word1.size() || i2 < word2.size()) {
            char c1 = i1 < word1.size() ? word1[i1][j1++] : '\0';
            char c2 = i2 < word2.size() ? word2[i2][j2++] : '\0';
            if (c1 != c2) return false;
            if (i1 < word1.size() && j1 == word1[i1].length())
                ++i1, j1 = 0;
            if (i2 < word2.size() && j2 == word2[i2].length())
                ++i2, j2 = 0;
        }
        return true;
    }
};
