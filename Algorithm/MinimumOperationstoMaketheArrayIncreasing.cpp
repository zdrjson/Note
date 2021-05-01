class Solution {
public:
    int minOperations(vector<int>& nums) {
        int ans = 0, last = 0;
        for (int x : nums)
            if (x <= last)
                ans += ++last - x;
            else
                last = x;
        return ans;
    }
};
