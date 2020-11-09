// Solution: Simulation
// Generate the array by the given rules.
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        if (n > 0) nums[1] = 1;
        for (int i = 1; i * 2 <= n; ++i) {
            nums[2 * i] = nums[i];
            if (i * 2 + 1 <= n) nums[2 * i + 1] = nums[i] + nums[i + 1];
        }
        int ans = Integer.MIN_VALUE;
        for (int e : nums)
            ans = Math.max(ans, e);
        return ans;
    }
}
