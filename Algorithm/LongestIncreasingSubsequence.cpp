// // Solution 1: DP
// class Solution {
// public:
//     int lengthOfLIS(vector<int>& nums) {
//         const int n = nums.size();
//         vector<int> dp(n, 1);
//         for (int i = 1; i < n; ++i)
//             for (int j = 0; j < i; ++j)
//                 if (nums[i] > nums[j])
//                     dp[i] = max(dp[i], dp[j] + 1);
//         return *max_element(begin(dp), end(dp));
//     }
// };

// Solution 2: DP + Greedy + Binary Search
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> dp;
        for (int x : nums) {
            auto it = lower_bound(begin(dp), end(dp), x);
            if (it == end(dp))
                dp.push_back(x);
            else
                *it = x;
        }
        return dp.size();
    }
};
