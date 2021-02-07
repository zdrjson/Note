// Solution: Prefix Sum
// ans = max{abs(prefix_sum[i] - max(prefix_sum[0:i])), abs(prefix_sum - min(prefix_sum[0:i]))}
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int lo = 0;
        int hi = 0;
        int s = 0;
        int ans = 0;
        for (int x : nums) {
            s += x;
            ans = Math.max(ans, Math.max(Math.abs(s - lo), Math.abs(s - hi)));
            hi = Math.max(s, hi);
            lo = Math.min(s, lo);
        }
        return ans;
    }
}
