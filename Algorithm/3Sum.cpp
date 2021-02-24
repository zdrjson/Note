// // Solution 1: Hashtable
// // Time complexity: O(n^2)
// // Space complexity: O(n)
// class Solution {
// public:
//     vector<vector<int>> threeSum(vector<int>& nums) {
//         sort(begin(nums), end(nums));
//         const int n = nums.size();
//         unordered_map<int, int> c;
//         for (int x : nums) ++c[x];
//         vector<vector<int>> ans;
//         for (int i = 0; i < n; ++i) {
//             if (i && nums[i] == nums[i - 1]) continue;
//             for (int j = i + 1; j < n; ++j) {
//                 if (j - 1 != i && nums[j] == nums[j - 1]) continue;
//                 const int t = 0 - nums[i] - nums[j];
//                 // nums[i] <= nums[j] <= nums[k]
//                 if (t < nums[j]) continue;
//                 if (!c.count(t)) continue;
//                 // Make sure we have enough count
//                 if (c[t] >= 1 + (nums[i] == t) + (nums[j] == t))
//                     ans.push_back({nums[i], nums[j], t});
//             }
//         }
//         return ans;
//     }
// };

// Solution 2: Sorting + Two pointers
// Time complexity: O(nlogn + n^2)
// Space complexity: O(1)
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(begin(nums), end(nums));
        const int n = nums.size();
        vector<vector<int>> ans;
        for (int i = 0; i < n; ++i) {
            if (i && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] > -nums[i]) --k;
                else if (nums[j] + nums[k] < -nums[i]) ++j;
                else {
                    ans.push_back({nums[i], nums[j], nums[k]});
                    while (j < k && nums[j] == nums[j + 1]) ++j;
                    while (j < k && nums[k] == nums[k - 1]) --k;
                    ++j, --k;
                }
            }
        }
        return ans;
    }
};
