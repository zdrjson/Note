// // Solution: Binary Search
// // Time complexity: O(logn)
// // Space complexity: O(1)
// class Solution {
// public:
//     int search(vector<int>& nums, int target) {
//         int l = 0;
//         int r = nums.size();
//         while (l < r) {
//             int m = (r - l) / 2 + l;
//             if (nums[m] == target)
//                 return m;
//             else if (nums[m] > target)
//                 r = m;
//             else
//                 l = m + 1;
//         }
//         return -1;
//     }
// };

// STL
class Solution {
public:
    int search(vector<int>& nums, int target) {
        auto it = lower_bound(nums.begin(), nums.end(), target);
        if (it == nums.end() || *it != target) return -1;
        return it - nums.begin();
    }
};
