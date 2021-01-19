class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        const int n = nums.size();
        unordered_map<int, int> m;
        int ans = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < i; ++j)
                ans += 8 * m[nums[i] * nums[j]]++;
        return ans;
    }
};
