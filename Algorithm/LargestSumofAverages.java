// Bottom-Up DP
// Time complexity: O(kn^2)
// Space complexity: O(n)
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[] dp = new double[n + 1];
        double[] sums = new double[n + 1];
        for (int i = 1; i <=n; ++i) {
            sums[i] = sums[i - 1] + A[i - 1];
            dp[i] = sums[i] / i;
        }
        for (int k = 2; k <= K; ++k) {
            double[] tmp = new double[n + 1];
            for (int i = k; i <= n; ++i)
                for (int j = k - 1; j < i; ++j)
                    tmp[i] = Math.max(tmp[i], dp[j] + (sums[i] - sums[j]) / (i - j));
            // double[] swap = dp;
            dp = tmp;
        }
        return dp[n];
    }
}

// // Bottom-Up DP
// // DP, use dp[k][i] to denote the largest average sum of partitioning first i elements into k groups.
// Init
// dp[1][i] = sum(a[0] ~ a[i - 1]) / i, for i in 1, 2, ... , n.
// Transition
// dp[k][i] = max(dp[k - 1][j] + sum(a[j] ~ a[i - 1]) / (i - j)) for j in k - 1,...,i-1.
// that is find the best j such that maximize dp[k][i]
// largest sum of partitioning first j elements (a[0] ~ a[j - 1]) into k - 1 groups (already computed) + average of a[j] ~ a[i - 1] (partition a[j] ~ a[i -1] into 1 group).
// Answer
// dp[K][n]
// // Time complexity: O(kn^2)
// // Space complexity: O(kn)
// class Solution {
//     public double largestSumOfAverages(int[] A, int K) {
//         int n = A.length;
//         double[][] dp = new double[K + 1][n + 1];
//         double[] sums = new double[n + 1];
//         for (int i = 1; i <= n; ++i) {
//             sums[i] = sums[i - 1] + A[i - 1];
//             dp[1][i] = sums[i] / i;
//         }
//         for (int k = 2; k <= K; ++k)
//             for (int i = k; i <= n; ++i)
//                 for (int j = k - 1; j < i; ++j)
//                     dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + (sums[i] - sums[j]) / (i - j));
//         return dp[K][n];
//     }
// }

// // Top-down DFS + memoriation
// class Solution {
//     private double[][] m_;
//     private double[] sums_;
//     public double largestSumOfAverages(int[] A, int K) {
//         int n = A.length;
//         m_ = new double[K + 1][n + 1];
//         sums_ = new double[n + 1];
//         for (int i = 1; i <= n; ++i)
//             sums_[i] = sums_[i - 1] + A[i - 1];
//         return LSA(A, n, K);
//     }
    
//     // Largest sum of averages for first n elements in A paritioned into k groups
//     private double LSA(int[] A, int n, int k) {
//         if (m_[k][n] > 0) return m_[k][n];
//         if (k == 1) return sums_[n] / n;
//         for (int i = k - 1; i < n; ++i)
//             m_[k][n] = Math.max(m_[k][n], LSA(A, i, k - 1) + (sums_[n] - sums_[i]) / (n - i));
//         return m_[k][n];
//     }
// }
