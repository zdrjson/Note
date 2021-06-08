// Solution: 
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (final int[] range : ops) {
            m = Math.min(m, range[0]);
            n = Math.min(n, range[1]);
        }
        return m * n;
    }
}
