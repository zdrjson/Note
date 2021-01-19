// Solution: HashTable
// Similar idea to 1.Two Sum
// Use a hashtable to store all the pair product counts.
// Enumerate all possible pairs, increase the answer by the same product counts * 8.
// Why time 8? C(4, 1) * C(1, 1) * C(2,1) * C(1,1)
// For pair one AxB, A can be placed at any position in a four tuple, B's position in then fixed. For another pair CxD, C has two positons to choose from, D is fixed.
// Time complexity: O(n^2)
// Space complexity: O(n^2)
class Solution {
    public int tupleSameProduct(int[] nums) {
        final int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < i; ++j) {
                int key = nums[i] * nums[j];
                ans += 8 * m.getOrDefault(key, 0);
                m.put(key, m.getOrDefault(key, 0) + 1);
            }
        return ans;
    }
}
