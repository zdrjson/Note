// Solution: Sliding Window
// Sort the elements, maintain a window such that it takes at most k ops to make the all the elements equal to nums[i].
// Time complexity: O(nlogn)
// Space complexity: O(1)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long sum = 0;
        int ans = 0;
        for (int r = 0; r < nums.length; ++r) {
            sum += nums[r];
            while (l < r &&
                   sum + k < (long)(nums[r] * (r - l + 1)))
                sum -= nums[l++];
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
