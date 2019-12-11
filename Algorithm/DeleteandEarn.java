class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int r = 0;
        for (int num : nums) {
            if (num > r) {
                r = num;
            }
        }
        int[] points = new int[r + 1];
        Arrays.fill(points, 0);
        for (int num : nums) {
            points[num] += num;
        }
        return rob(points);
    }
    private int rob(int[] points) {
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 0; i < points.length; ++i) {
            int dp = Math.max(dp2 + points[i], dp1);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
