// Solution: Sum each row up
// Time complexity: O(mn)
// Space complexity: O(1)
class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] row : accounts) {
            int sum_row = 0;
            for (int i = 0; i < row.length; ++i)
                sum_row += row[i];
            ans = Math.max(ans, sum_row);
        }
        return ans;
    }
}
