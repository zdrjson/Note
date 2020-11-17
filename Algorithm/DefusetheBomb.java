// Solution 1: Simulation
// Time complexity: O(n*k)
// Space complexity: O(n)
class Solution {
    public int[] decrypt(int[] code, int k) {
        final int n = code.length;
        int[] ans = new int[n];
        int sign = k > 0 ? 1 : -1;
        for (int i = 0; i < n; ++i)
            for (int j = 1; j <= Math.abs(k); ++j)
                ans[i] += code[(i + j * sign + n) % n];
        return ans;
    }
}
