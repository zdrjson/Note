// Solution: Math
// Enumerate all possible gcds (1 to max(nums)), and check whether there is a subset of the numbers that can form a given gcd i.
// If we want to check whether 10 is a valid gcd, we found all multipliers of 10 in the array and compute their gcd.
// ex1 gcd(10, 20, 30) = 10, true
// ex2 gcd(20, 40, 40) = 20, false
// Time complexity: O(mlogm)
// Space complexity: O(m)
class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int kMax = Integer.MIN_VALUE;
        for (int x : nums) kMax = Math.max(kMax, x);
        int[] s = new int[kMax + 1];
        for (int x : nums) s[x] = 1;
        int ans = 0;
        for (int i = 1; i <= kMax; ++i) {
            int g = 0;
            for (int j = i; j <= kMax; j += i)
                if (s[j] != 0) g = gcd(g, j);
            ans += g == i ? 1 : 0;
        }
        return ans;
    }
    private int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
