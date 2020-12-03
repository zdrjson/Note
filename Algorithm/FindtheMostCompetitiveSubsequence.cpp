class Solution {
public:
    vector<int> mostCompetitive(vector<int>& nums, int k) {
        const int n = nums.size();
        vector<int> ans (k);
        int c = 0;
        for (int i = 0; i < n; ++i) {
            while (c && ans[c - 1] > nums[i] && c + n - i - 1 >= k)
                --c;
            if (c < k) ans[c++] = nums[i];
        }
        return ans;
    }
};
