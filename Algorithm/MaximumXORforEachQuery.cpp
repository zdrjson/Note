class Solution {
public:
    vector<int> getMaximumXor(vector<int>& nums, int maximumBit) {
        const int t = (1 << maximumBit) - 1;
        const int n = nums.size();
        vector<int> ans(n);
        int s = 0;
        for (int x : nums) s ^= x;
        for (int i = n - 1; i >= 0; --i) {
            ans[n - i - 1] = t ^ s;
            s ^= nums[i];
        }
        return ans;
    }
};
