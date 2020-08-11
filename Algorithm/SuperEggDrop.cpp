// // Solution 1: Recursion with Memorization (TLE)
// // dp[k][n] := min number of moves to test n floors with k eggs.
// // Base cases:
// // dp[0][n] = 0 # no eggs left.
// // dp[1][n] = n # one egg, need to test every floor.
// // Transition:
// // dp[k][n] = min(1 + max(dp[k][i - 1], dp[k - 1][n - i])) 1 <= i <= n
// // Time complexity: O(k*n^2)
// // Space complexity: O(k*n)
// class Solution {
// public:
//     int superEggDrop(int K, int N) {
//         m_ = vector<vector<int>>(K + 1, vector<int>(N + 1, INT_MIN));
//         return dp(K, N);
//     }
// private:
//     // m[i][j] := min moves of i eggs and j floors
//     vector<vector<int>> m_;
    
//     int dp(int k, int n) {
//         if (k <= 0) return 0;
//         if (k == 1) return n;
//         if (n <= 1) return n;
//         if (m_[k][n] != INT_MIN) return m_[k][n];
//         int ans = INT_MAX;
//         for (int i = 1; i <= n; ++i)
//             ans = min(ans, 1 + max(dp(k - 1, i - 1), // broken at floor i, need to test i - 1 floors using k - 1 eggs.
//                                    dp(k, n - i))); // unbroken at floor i, need to test n - i floors using k eggs.
//         return m_[k][n] = ans;
//     }
// };

// Solution 2: Solution 1 + Binary Search
// Time compleixty: O(k*n*logn)
// Space compleixty: O(k*n)
class Solution {
public: 
    int superEggDrop(int K, int N) {
        m_ = vector<vector<int>>(K + 1, vector<int>(N + 1, INT_MIN));
        return dp(K, N);
    }
private:
    // m[i][j] := min moves of i eggs and j floors
    vector<vector<int>> m_;
    
    int dp(int k, int n) {
        if (k <= 0) return 0;
        if (k == 1) return n;
        if (n <= 1) return n;
        if (m_[k][n] != INT_MIN) return m_[k][n];
        
        // broken[i] = dp(k - 1, i - 1) is increasing with i.
        // unbroken[i] = dp(k,   n - i) is decreasing with i.
        // dp[k][n] = 1 + min(max(broken[i], unbroken[i])), 1 <= i <= n
        // which minimizes max(broken[i], unbroken[i]).
        int l = 1;
        int r = n + 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            int broken = dp(k - 1, m - 1);
            int unbroken = dp(k, n - m);
            if (broken >= unbroken)
                r = m;
            else
                l = m + 1;
        }
        
        return m_[k][n] = 1 + dp(k - 1, l - 1);
    }
};
