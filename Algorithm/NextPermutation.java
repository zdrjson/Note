// Solution
// Find the last acceding element x, swap with the smallest number y, y is after x that and y is greater than x.
// Reverse the elements after x.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) --i;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) --j;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums = reverse(nums, i + 1, nums.length - 1);
    }
    private int[] reverse(int[] nums, int x, int y) {
        for (int i = x, j = y; i < j; ++i, --j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
