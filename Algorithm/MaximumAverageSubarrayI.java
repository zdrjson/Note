// Solution: Sliding Window
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        final int n = nums.length;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (i >= k) sum -= nums[i - k];
            sum += nums[i];
            if (i + 1 >= k) ans = Math.max(ans, sum);
        }
        return (double)ans / k;
    }
}
