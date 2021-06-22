// Solution 1: Binary Search
// Find the smallest x, such that there are k elements that are smaller or equal to x.
// Time complexity: O(nlogn*log(max-min))
// Space complexity: O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1] + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int total = 0;
            for (int i = 0; i < n; ++i) { 
                for (int j = 0; j < n; ++j) // 这里用下面的方法更快 用二分搜索更快 (待优化)。
                    if (matrix[i][j] <= m) 
                        ++total;   
            }
            if (total >= k) 
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}

// // 下面这个稍微快点
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         int n = matrix.length;
//         int l = matrix[0][0];
//         int r = matrix[n - 1][n - 1] + 1;
//         while (l < r) {
//             int m = l + (r - l) / 2;
//             int total = 0;
//             int j = n - 1;
//             for (int i = 0; i < n; ++i) {
//                 while (j >= 0 && matrix[i][j] > m) 
//                     j--;
//                 total += j + 1;
//             }
//             if (total >= k) 
//                 r = m;
//             else 
//                 l = m + 1;
//         }
//         return l;
//     }
// }
