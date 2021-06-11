// Solution: Brute Force
// Time complexity: O(mn)
// Space complexity: O(mn)
class Solution {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans[j][i] = A[i][j];
        return ans;
    }
}
