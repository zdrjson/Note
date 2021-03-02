// Solution: Greedy
// Assuming sum(nums1) < sum(nums2),
// sort both arrays
// * scan nums1 from left to right, we need to increase the value from the smallest one.
// * scan nums2 from right to left, we need to decrease the value from the largest one.
// Each time, select the one with the largest delta to change.
// e.g. nums1[i] = 2, nums2[j] = 4, delta1 = 6 - 2 = 4, delta2 = 4 - 1 = 3, Increase 2 to 6 instead of decreasing 4 to 1.
// Time complexity: O(mlogm + nlogn)
// Space complexity: O(1)
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        final int l1 = nums1.length;
        final int l2 = nums2.length;
        if (Math.min(l1, l2) * 6 < Math.max(l1, l2)) return -1;
        int s1 = 0;
        for (int num : nums1)
            s1 += num;
        int s2 = 0;
        for (int num : nums2)
            s2 += num;
        if (s1 > s2) return minOperations(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 0;
        int i = 0;
        int j = l2 - 1;
        while (s1 != s2) {
            final int diff = s2 - s1;
            if (j == l2 || (i != l1 && 6 - nums1[i] >= nums2[j] - 1)) {
                final int x = Math.min(6, nums1[i] + diff);
                s1 += x - nums1[i++];
            } else {
                final int x = Math.max(1, nums2[j] - diff);
                s2 += x - nums2[j--];
            }
            ++ans;
        }
        return ans;
    }
}
