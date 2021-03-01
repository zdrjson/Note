class Solution {
public:
    vector<int> minOperations(string boxes) {
        const int n = boxes.size();
        vector<int> ans(n);
        for (int i = 0, c = 0, s = 0; i < n; ++i) {
            ans[i] += c;
            c += (s += boxes[i] - '0');
        }
        for (int i = n - 1, c = 0, s = 0; i >= 0; --i) {
            ans[i] += c;
            c += (s += boxes[i] - '0');
        }
        return ans;
    }
};
