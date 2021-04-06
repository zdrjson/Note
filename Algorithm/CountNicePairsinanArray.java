// Solution: Two Sum
// Key = x - rev(x)
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int countNicePairs(int[] nums) {
        final int kMod = (int)1e9 + 7;
        Map<Integer, Integer> m = new HashMap<>();
        long ans = 0;
        for (int x : nums) {
            StringBuilder s = new StringBuilder(String.valueOf(x)); // new StringBuilder(x) x是数字的话里面初始化的是capacity!!!
            s.reverse();
            final int key = x - Integer.valueOf(s.toString());
            ans += m.getOrDefault(key, 0);
            m.put(key, m.getOrDefault(key, 0) + 1);
        }
        return (int)(ans % kMod); // int强制转换要加在外面。
    }
}
