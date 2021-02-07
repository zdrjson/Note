class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        int lo = 0;
        int hi = 0;
        int s = 0;
        int ans = 0;
        for (int x : nums) {
            s += x;
            ans = max({ans, abs(s - lo), abs(s - hi)});
            hi = max(s, hi);
            lo = min(s, lo);
        }
        return ans;
    }
};
