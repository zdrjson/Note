class Solution {
public:
    string getSmallestString(int n, int k) {
        string ans(n, 'a');
        k -= n;
        while (k) {
            int d = min(k, 25);
            ans[--n] += d;
            k -= d;
        }
        return ans;
    }
};
