// Solution: Binary Search
// Greedy won't work, e.g. finding the max diff and replace it. Counter example:
// nums1 = [7,5], nums2 = [1, -2]
// pair1 = abs(7 - 1) = 6
// pair2 = abs(5 - (-1)) = 7
// If we replace 5 with 7, we got pair2' = abs(7 - (-2)) = 9 > 7.
// Every pair of numbers can be the candidage, we just need to find the closest number for each nums2[i].
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int kMod = (int)1e9 + 7;
        final int n = nums1.length;
        long ans = 0;
        int gain = 0;
        TreeSet<Integer> s = new TreeSet<Integer>();
        for (int num1 : nums1)
            s.add(num1);
        for (int i = 0; i < n; ++i) {
            final int diff = Math.abs(nums1[i] - nums2[i]);
            ans += diff;
            if (diff <= gain) continue;
            Integer it = s.ceiling(nums2[i]);
            if (it != null)
                gain = Math.max(gain, diff - Math.abs(it - nums2[i]));
            Integer it1 = s.floor(nums2[i]); // 相当于C++的 prev。
            if (it1 != null)
                gain = Math.max(gain, diff - Math.abs(it1 - nums2[i]));
        }
        return (int)((ans - gain) % kMod);
    }
}
