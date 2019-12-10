class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            int dp = Math.max(dp2 + nums[i], dp1);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
