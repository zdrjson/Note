// Solution: Sliding window + Hashset
// Maintabin a window that has no duplicate elements
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        final int n = nums.length;
        Set<Integer> t = new HashSet<Integer>();
        int ans = 0;
        for (int l = 0, r = 0, s = 0; r < n; ++r) {
            while (t.contains(nums[r]) && l < r) {
                s -= nums[l];
                t.remove(nums[l++]);
            }
            t.add(nums[r]);
            ans = Math.max(ans, s += nums[r]);
        }
        return ans;
    }
}
