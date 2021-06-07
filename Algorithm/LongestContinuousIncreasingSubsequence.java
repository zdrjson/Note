// Solution: Dynamic Programming
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int cur = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                ++cur;
                ans = Math.max(ans, cur);
            } else {
                cur = 1;
            }
        }
        return ans;
    }
}
