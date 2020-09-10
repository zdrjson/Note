// Solution: Hashtable
// For each number y in the second array, count its frequency.
// For each number x in the second array, count its frequency.
// if r == y: ans += f[y] * f[y-1]
// else ans += f[y] * f[r]
// Final ans /= 2
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return solve(nums1, nums2) + solve(nums2, nums1);
    }
    private int solve(int[] nums1, int[] nums2) {
        int ans = 0;
        Map<Long, Integer> f = new HashMap<>();
        for (int y : nums2) f.put((long)y, f.getOrDefault((long)y, 0) + 1);
        for (long x : nums1) 
            for (Map.Entry<Long, Integer> kv : f.entrySet()) {
                long r = x * x / kv.getKey(); // x最大为10^5，两个相乘大于int类型，所以这里用long类型在接。相应的Map里面的key值也设置成Long类型才能运行正确。
                if (x * x % kv.getKey() != 0 || !f.containsKey(r)) continue;
                if (r == kv.getKey()) ans += kv.getValue() * (kv.getValue() - 1);
                else ans += kv.getValue() * f.get(r);
            }
        return ans / 2;
    }
}
