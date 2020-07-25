class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        const int n = nums.size();
        if (n <= 1) return n;
        int ans = 0;
        int i = 0;
        while (i < n) {
            nums[ans++] = nums[i];
            int j = i + 1;
            while (j < n && nums[j] == nums[j - 1]) ++j;
            i = j;
        }
        return ans;
    }
};
