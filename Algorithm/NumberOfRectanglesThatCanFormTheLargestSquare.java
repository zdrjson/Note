// Solution: Running Max of Shortest Edge
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int cur = 0;
        int ans = 0;
        for (int[] r : rectangles) {
            if (Math.min(r[0], r[1]) > cur) {
                cur = Math.min(r[0], r[1]);
                ans = 0;
            }
            if (Math.min(r[0], r[1]) == cur) ++ans;
        }
        return ans;
    }
}
