// Solution: Two Pointers
// maintain a window [i, j], m = min(nums[i~j]), expend to the left if nums[i - 1] >= nums[j + 1], otherwise expend to the right.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int maximumScore(int[] nums, int k) {
        final int n = nums.length;
        int ans = 0;
        for (int i = k, j = k, m = nums[k];;) {
            ans = Math.max(ans, m * (j - i + 1));
            if (j - i + 1 == n) break;
            int l = i != 0 ? nums[i - 1] : -1;
            int r = j + 1 < n ? nums[j + 1] : -1;
            if (l >= r)
                m = Math.min(m, nums[--i]);
            else
                m = Math.min(m, nums[++j]);
        }
        return ans;
    }
}
