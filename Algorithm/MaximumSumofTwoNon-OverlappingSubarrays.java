// Solution: Prefix sum
// Time complexity: O(n^2)
// Space complexity: O(n)
class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i)
            s[i + 1] = s[i] + A[i];
        int ans = 0;
        for (int i = 0; i <= n - L; ++i) {
            int ls = s[i + L] - s[i];
            int ms = Math.max(maxSum(s, 0, i - M - 1, M),
                              maxSum(s, i + L, n - M, M));
            ans = Math.max(ans, ls + ms);
        }
        return ans;
    }
    private int maxSum(int[] s, int start, int end, int l) {
        int ans = Integer.MIN_VALUE;
        for (int i = start; i <= end; ++i) 
            ans = Math.max(ans, s[i + l] - s[i]);
        return ans;
    }
}
