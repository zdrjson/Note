class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        const int n = nums.size();
        int ans = 0;
        for (int i = k, j = k, m = nums[k];;) {
            ans = max(ans, m * (j - i + 1));
            if (j - i + 1 == n) break;
            int l = i ? nums[i - 1] : -1;
            int r = j + 1 < n ? nums[j + 1] : -1;
            if (l >= r)
                m = min(m, nums[--i]);
            else
                m = min(m, nums[++j]);
        }
        return ans;
    }
};
