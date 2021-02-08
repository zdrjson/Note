// Solution: Counting and checking
// Count how many turning points (nums[i] < nums[i - 1]) in the array. Return false if there are more than 1. For the turning point r, (nums[r] < nums[r - 1]), return true if both of the following conditions are satisfied:
// 1. nums[r - 1] is the largest number, e.g. nums[r - 1] >= nums[n - 1]
// 2. nums[r] is the smallest number, e.g. nums[r] <= nums[0]
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int r = -1;
        for (int i = 1; i < nums.length; ++i) 
            if (nums[i] < nums[i - 1]) {
                ++count;
                r = i;
            }
        if (count == 0) return true;
        if (count > 1) return false;
        return nums[r] <= nums[0] && nums[r - 1] >= nums[nums.length - 1];
    }
}
