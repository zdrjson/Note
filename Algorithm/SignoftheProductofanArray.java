// Solution: Sign Only
// No need to compute the product, only track the sign changes. Flip the sign when encounter a negative number, return 0 if there is any 0 in the array.
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int arraySign(int[] nums) {
        int sign = 1;
        for (int x : nums) {
            if (x == 0) return 0;
            else if (x < 0) sign = -sign;
        }
        return sign;
    }
}
