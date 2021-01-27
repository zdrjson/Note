// // Solution 1: Frequency Map
// class Solution {
// public:
//     int maxOperations(vector<int>& nums, int k) {
//         unordered_map<int, int> m;
//         int ans = 0;
//         for (int x : nums) ++m[x];
//         for (int x : nums) {
//             if (m[x] < 1 || m[k - x] < 1 + (x + x == k)) continue;
//             --m[x];
//             --m[k - x];
//             ++ans;
//         }
//         return ans;
//     }
// };

// Solution 2: Two Pointers
// Sort the number, start from i = 0, j = n - 1, compare s = nums[i] + nums[j] with k and move i,j accordingly.
// Time complexity: O(nlogn)
// Space complexity: O(1)
class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        sort(begin(nums), end(nums));
        int i = 0, j = nums.size() - 1;
        int ans = 0;
        while (i < j) {
            const int s = nums[i] + nums[j];
            if (s == k) {
                ++ans;
                ++i; --j;
            } else if (s < k) {
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }
};
