// Solution: Sum for each row and column
// Brute force:
// Time complexity: O(R*C*(R+C))
// Space complexity: O(1)
// We can pre-compute the sums for each row and each column, ans = sum(mat[r][c] == 1 and rsum[r] == 1 and csum[c] == 1)
// Time complexity: O(R*C)
// Space complexity: O(R+C)
class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] rs = new int[rows];
        int[] cs = new int[cols];
        for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c) {
                rs[r] += mat[r][c];
                cs[c] += mat[r][c];
            }
        int ans = 0;
        for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c) 
                ans += (mat[r][c] == 1 && rs[r] == 1 && cs[c] == 1) ? 1 : 0;
        return ans;
    }
}
