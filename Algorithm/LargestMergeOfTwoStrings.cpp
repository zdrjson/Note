class Solution {
public:
    string largestMerge(string w1, string w2) {
        string ans;
        int m = w1.length(), n = w2.length();
        int i = 0, j = 0;
        while (i < m && j < n)
            ans += w1.substr(i) > w2.substr(j) ? w1[i++] : w2[j++];
        ans.append(w1.substr(i));
        ans.append(w2.substr(j));
        return ans;
    }
};
