// // Solution 1: Frequency Map
// // For each x, check freq[x] and freq[k - x]. Note: there is a special case when x + x == k.
// // Time complexity: O(n)
// // Space complexity: O(n)
// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         Map<Integer, Integer> m = new HashMap<>();
//         int ans = 0;
//         for (int x : nums) m.put(x, m.getOrDefault(x, 0) + 1);
//         for (int x : nums) {    // key为k - x有可能不在map中，所以要用getOrDefault()方法。
//             if (m.get(x) < 1 || m.getOrDefault(k - x, 0) < 1 + (x + x == k ? 1 : 0)) continue;
//             m.put(x, m.get(x) - 1);
//             m.put(k - x, m.get(k - x) - 1);
//             ++ans;
//         }
//         return ans;
//     }
// }

// Solution 2: Two Pointers
// Sort the number, start from i = 0, j = n - 1, compare s = nums[i] + nums[j] with k and move i, j accordingly.
// Time complexity: O(nlogn)
// Space complexity: O(1)
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int ans = 0;
        while (i < j) {
            final int s = nums[i] + nums[j];
            if (s == k) {
                ++ans;
                ++i; --j;
            } else if (s < k) {
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }
}
