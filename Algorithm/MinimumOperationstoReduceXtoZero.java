// // Solution1: Prefix Sum + Hashtable
// // Time complexity: O(n)
// // Space complexity: O(n)
// class Solution {
//     public int minOperations(int[] nums, int x) {
//         final int n = nums.length;
//         int[] l = new int[n], r = new int[n];
//         Map<Integer, Integer> ml = new HashMap<Integer, Integer>(), mr = new HashMap<Integer, Integer>();
//         ml.put(0, -1); // 注意给ml, mr初始化key = 0, value = -1，不然答案不对。
//         mr.put(0, -1);
//         for (int i = 0; i < n; ++i) {
//             l[i] = nums[i] + (i > 0 ? l[i - 1] : 0);
//             r[i] = nums[n - i - 1] + (i > 0 ? r[i - 1] : 0);
//             ml.put(l[i], i);
//             mr.put(r[i], i);
//         }
//         int ans = Integer.MAX_VALUE;
//         for (int i = 0; i < n; ++i) {
//             int s1 = x - l[i];
//             Integer it1 = mr.get(s1);
//             if (it1 != null) ans = Math.min(ans, i + 1 + it1 + 1);
//             int s2 = x - r[i];
//             Integer it2 = ml.get(s2);
//             if (it2 != null) ans = Math.min(ans, i + 1 + it2 + 1);
//         }
//         return ans > n ? -1 : ans;
//     }
// }

// Solution2: Sliding Window
// Find the longest sliding window whose sum of elements equals sum(nums) - x
// ans = n - window_size
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int minOperations(int[] nums, int x) {
        final int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        int target = sum - x;
        int ans = Integer.MAX_VALUE;
        for (int s = 0, l = 0, r = 0; r < n; ++r) {
            s += nums[r];
            while (s > target && l <= r) s -= nums[l++];
            if (s == target) ans = Math.min(ans, n - (r - l + 1));
        }
        return ans > n ? -1 : ans;
    }
}
