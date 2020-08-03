// Solution 0: Brute Force (TLE)
// Try all pairs
// Time complexity: O(n^2)
// Space complexirty: O(1)

// Solution 1: Math
// Find the min/max element of the array
// min + k v.s. max - k
// ans = max(0, (max - min) - 2 * k)
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int a_min = Integer.MAX_VALUE;
        int a_max = Integer.MIN_VALUE;
        for (int a : A) {
            a_min = Math.min(a_min, a);
            a_max = Math.max(a_max, a);
        }
        return Math.max(0, (a_max - a_min) - 2 * K);
    }
}
