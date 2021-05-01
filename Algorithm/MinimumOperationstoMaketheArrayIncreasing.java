// Solution: Track Last
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int minOperations(int[] nums) {
        int ans = 0, last = 0;
        for (int x : nums) 
            if (x <= last)
                ans += ++last - x;
            else
                last = x;
        return ans;
    }
}
