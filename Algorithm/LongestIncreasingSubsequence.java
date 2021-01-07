// // Solution 1: DP
// // Time complexity: O(n^2)
// // Space complexity: O(n)
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         final int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         for (int i = 0; i < n; ++i)
//             for (int j = 0; j < i; ++j)
//                 if (nums[i] > nums[j])
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//         int ans = Integer.MIN_VALUE;
//         for (int e : dp)
//             ans = Math.max(ans, e);
//         return ans;
//     }
// }

// Solution 2: DP + Greedy + Binary Search / Patience Sort
// dp[i] := smallest tailing number of a increasing subsequence of length i + 1.
// dp is an increasing array, we can use binary search to find the index to insert/update the array.
// ans = len(dp)
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int x : nums) {
            int it = lower_bound(dp, x, 0, dp.size());
            if (it == dp.size())
                dp.add(x);
            else
                dp.set(it, x);
        }
        return dp.size();
    }
    private int lower_bound(List<Integer> A, int val, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (A.get(m) >= val)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
