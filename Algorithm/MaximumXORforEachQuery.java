// Solution: Prefix XOR
// Compute s = nums[0] ^ nums[1] ^ ...nums[n-1] first
// to remove nums[i], we just need to do s ^= nums[i]
// We can always maximize the xor of s and k to (2^maxbit - 1)
// k = (2 ^ maxbit - 1) ^ s
// Time complexity: O(n)
// Space complexity: O(1)
// 不是太懂
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        final int t = (1 << maximumBit) - 1; // 1 << maximumBit一定要加括号，否则运算顺序出错，答案不多！！！
        final int n = nums.length;
        int[] ans = new int[n];
        int s = 0;
        for (int x : nums) s ^= x;
        for (int i = n - 1; i >= 0; --i) {
            ans[n - i - 1] = t ^ s;
            s ^= nums[i];
        }
        return ans;
    }
}
