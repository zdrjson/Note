// Solution: DP + Sorting
// Time complexity: O(m*n*log(n))
// Space complexity: O(1)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        for (int j = 0; j < n; ++j)
            for (int i = 1; i < m; ++i)
                if (matrix[i][j] == 1) matrix[i][j] += matrix[i - 1][j];
        
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            int[] row = matrix[i]; // 直接用matrix[i]替换下面的row，编译不通过。
            Arrays.setAll(row, k -> ~row[k]);
            Arrays.sort(matrix[i]);
            Arrays.setAll(row, k -> ~row[k]);
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, (j + 1) * matrix[i][j]);
        }
        return ans;
    }
}
