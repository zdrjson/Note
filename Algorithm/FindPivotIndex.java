/*
Time complexity : O(n)
Space complexity: O(1)
*/
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = IntStream.of(nums).sum(); //这个方法比下面的慢点
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) sum += nums[i];
        int l = 0;
        int r = sum;
        for (int i = 0; i < nums.length; ++i) {
            r -= nums[i];
            if (l == r) return i;
            l += nums[i];
        }
        return -1;
    }
}
