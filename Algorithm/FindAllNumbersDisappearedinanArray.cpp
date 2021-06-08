class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        for (size_t i = 0; i != nums.size(); ++i) {
            int index = abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] *= -1;
        }
        vector<int> ans;
        for (size_t i = 0; i != nums.size(); ++i) 
            if (nums[i] > 0) ans.push_back(i + 1);
        return ans;
    }
};
