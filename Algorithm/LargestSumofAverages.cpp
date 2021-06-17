// Solution 1:Dp
// Time complexity: (kn^2)
// Space complexity: O(kn)
class Solution {
public:
    double largestSumOfAverages(vector<int>& A, int K) {
        const int n = A.size();
        vector<vector<double>> dp(K + 1, vector<double>(n + 1, 0.0));
        vector<double> sums(n + 1, 0.0);
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + A[i - 1];
            dp[1][i] = static_cast<double>(sums[i]) / i;
        }
        for (int k = 2; k <= K; ++k)
            for (int i = k; i <= n; ++i)
                for (int j = k - 1; j < i; ++j)
                    dp[k][i] = max(dp[k][i], dp[k - 1][j] + (sums[i] - sums[j]) / (i - j));
        return dp[K][n];
    }
};

// // Space complexity: O(n)
// class Solution {
// public:
//     double largestSumOfAverages(vector<int>& A, int K) {
//         const int n = A.size();
//         vector<double> dp(n + 1, 0.0);
//         vector<double> sums(n + 1, 0.0);
//         for (int i = 1; i <= n; ++i) {
//             sums[i] = sums[i - 1] + A[i - 1];
//             dp[i] = static_cast<double>(sums[i]) / i;
//         }
//         for (int k = 2; k <= K; ++k) {
//             vector<double> tmp(n + 1, 0.0);
//             for (int i = k; i <= n; ++i)
//                 for (int j = k - 1; j < i; ++j)
//                     tmp[i] = max(tmp[i], dp[j] + (sums[i] - sums[j]) / (i - j));
//             dp.swap(tmp);
//         }
//         return dp[n];
//     }
// };

// // Solution: DFS + memoriation
// class Solution {
// public:
//     double largestSumOfAverages(vector<int>& A, int K) {   
//         const int n = A.size();
//         m_ = vector<vector<double>>(K + 1, vector<double>(n + 1, 0.0));
//         sums_ = vector<double>(n + 1, 0.0);
//         for (int i = 1; i <= n; ++i)
//             sums_[i] = sums_[i - 1] + A[i - 1];
//         return LSA(A, n, K);
//     }
// private:
//     vector<vector<double>> m_;
//     vector<double> sums_;
    
//     // Largest sum of averages for first n elements in A paritioned into k groups
//     double LSA(const vector<int>& A, int n, int k) {
//         if (m_[k][n] > 0) return m_[k][n];
//         if (k == 1) return sums_[n] / n;
//         for (int i = k - 1; i < n; ++i)
//             m_[k][n] = max(m_[k][n], LSA(A, i, k - 1) + (sums_[n] - sums_[i]) / (n - i));
//         return m_[k][n];
//     }
// };
