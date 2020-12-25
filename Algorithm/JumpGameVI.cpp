// // Time complexity: O(n)
// // Space complexity: O(n+k) -> O(k)
// class Solution {
// public:
//     int maxResult(vector<int>& nums, int k) {
//         const int n = nums.size();
//         vector<int> dp(n);
//         deque<int> q{{0}};
//         dp[0] = nums[0];
//         for (int i = 1; i < n; ++i) {
//             dp[i] = nums[i] + dp[q.front()];
//             while (!q.empty() && dp[i] >= dp[q.back()]) q.pop_back();
//             while (!q.empty() && i - q.front() >= k) q.pop_front();
//             q.push_back(i);
//         }
//         return dp[n - 1];
//     }
// };

// Space complexity: O(k)
class Solution {
public:
    int maxResult(vector<int>& nums, int k) {
        const int n = nums.size();
        deque<pair<int, int>> q{{nums[0], 0}};
        for (int i = 1; i < n; ++i) {
            const int cur = nums[i] + q.front().first;
            while (!q.empty() && cur >= q.back().first)
                q.pop_back();
            while (!q.empty() && i - q.front().second >= k)
                q.pop_front();
            q.emplace_back(cur, i);
        }
        for (const auto& [v, i] : q)
            if (i == n - 1) return v;
        return 0;
    }
};
