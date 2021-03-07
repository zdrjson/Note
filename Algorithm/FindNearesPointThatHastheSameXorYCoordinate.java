// Solution: Brute Force
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min_dist = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < points.length; ++i) {
            final int dx = Math.abs(points[i][0] - x);
            final int dy = Math.abs(points[i][1] - y);
            if (dx * dy == 0 && dx + dy < min_dist) {
                min_dist = dx + dy;
                ans = i;
            }
        }
        return ans;
    }
}
