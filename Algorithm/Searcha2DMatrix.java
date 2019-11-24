/**
 * Treat the 2D array as a 1D array. matrix[index / cols][index % cols]
 * Time complexity: O(log(m * n))
 * Space complexity: O(1)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int l = 0;
        int r = matrix.length * matrix[0].length;
        int cols = matrix[0].length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (matrix[m / cols][m % cols] == target) {
                return true;
            } else if (matrix[m / cols][m % cols] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}