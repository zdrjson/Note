// Solution: Sort by x coordinates
// Time complexity: O(nlogn)
// Space complexity: O(n)
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int ans = 0;
        for (int i = 1; i < points.length; ++i)
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        return ans;
    }
}
