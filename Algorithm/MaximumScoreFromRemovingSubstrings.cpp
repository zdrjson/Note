class Solution {
public:
    int maximumGain(string s, int x, int y) {
        // Remove pattern p from s for t points each.
        // Returns the total score.
        auto remove = [&](const string& p, int t) {
            int total = 0;
            int i = 0;
            for (int j = 0; j < s.size(); ++j, ++i) {
                s[i] = s[j];
                if (i && s[i - 1] == p[0] && s[i] == p[1]) {
                    i -= 2;
                    total += t;
                }
            }
            s.resize(i);
            return total;
        };
        string px{"ab"};
        string py{"ba"};
        if (y > x) {
            swap(px, py);
            swap(x, y);
        }
        return remove(px, x) + remove(py, y);
    }
};
