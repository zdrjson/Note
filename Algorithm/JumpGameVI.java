// // Solution: DP + Monotonic Queue
// // dp[i] = nums[i] + max(dp[j]) i - k <= j < i
// // Brute force time complexity: O(n*k) => TLE
// // This problem can be reduced to find the maximum for a sliding window that can be solved by monotonic queue.
// // Time complexity: O(n)
// // Space complexity: O(n+k) -> O(k)
// class Solution {
//     public int maxResult(int[] nums, int k) {
//         final int n = nums.length;
//         Deque<Integer> q = new LinkedList<Integer>(Arrays.asList(0));
//         int[] dp = new int[n];
//         dp[0] = nums[0];
//         for (int i = 1; i < n; ++i) {
//             dp[i] = nums[i] + dp[q.peekFirst()];
//             while (!q.isEmpty() && dp[i] >= dp[q.peekLast()]) q.pollLast();
//             while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();
//             q.offerLast(i);
//         }
//         return dp[n - 1];
//     }
// }

class Solution {
    public int maxResult(int[] nums, int k) {
        final int n = nums.length;
        Deque<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{nums[0], 0});
        for (int i = 1; i < n; ++i) {
            final int cur = nums[i] + q.peekFirst()[0];
            while (!q.isEmpty() && cur >= q.peekLast()[0]) 
                q.pollLast();
            while (!q.isEmpty() && i - q.peekFirst()[1] >= k) 
                q.pollFirst();
            q.offerLast(new int[]{cur, i});
        }
        for (int[] vi : q) 
            if (vi[1] == n - 1) return vi[0];
        return 0;
    }
}
