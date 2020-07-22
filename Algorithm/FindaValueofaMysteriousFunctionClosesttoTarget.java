// Solution: Brute Force w/ Optimization
// Try all possible [l,r] range with pruning.
// 1. for a given l, we extend r, since s & x <= s, if s becomes less than target, we can stop the inner loop.
// 2. Case 1, s = arr[l] & ... & arr[n-1], s > target,
// Let s' = arr[l+1] & ... & arr[n-1], s' >= s,
// if s > target, then s' > target, we can stop outer loop as well.
// Case 2, inner loop stops at r, s = arr[l] & ... & arr[r], s <= target, we continue with l+1.
// Time complexity: O(n)? on average, O(n^2) in worst case.
// Space complexity: O(1)
class Solution {
    public int closestToTarget(int[] arr, int target) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int s = arr[i];
            for (int j = i; j < n; ++j) {
                s &= arr[j];
                ans = Math.min(ans, Math.abs(s - target));
                if (ans == 0) return 0;
                if (s <= target) break; // s is decreasing.
            }
            if (s > target) break; // s is increasing.
        }
        return ans;
    }
}
