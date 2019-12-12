class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        for (int j = 0; j < n; ++j) {
            int w = 0;
            int h = 0;
            for (int i = j; i >= 0; --i) {
                if ((w += books[i][0]) > shelf_width) {
                    break;
                }
                h = Math.max(h, books[i][1]);
                dp[j] = Math.min(dp[j], (i == 0 ? 0 : dp[i - 1]) + h);
            }
        }
        return dp[n - 1];
    }
}
