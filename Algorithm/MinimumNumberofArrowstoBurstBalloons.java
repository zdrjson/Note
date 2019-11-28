// This problem is very similar to 435. The difference is that in this problem, we can shoot two balloon with one shot by shooting at edge of two intervals, like for [1,2],[2,3], we can shoot at 2. And also to find the minimum arrows means we need to find out maximum non overlapping intervals.
//Athough in this problem.LC uses int[] to represent interval, let's talk it as interval. Firstly sort the interval by end in ascending order. Then scan the array to find out how many non-overlappling intervals. The time complexity is O(N*logN), space complexity is O(1).
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int right = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > right) { // here is >, not >=, since if they are equal, it indicates they are overlappe.
                right = point[1];
                ++ans;
            } // we don't need to update end if they are overlapped.
        }
        return ans;
    }
}
