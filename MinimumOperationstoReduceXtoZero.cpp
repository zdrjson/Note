// // Solution 1: Prefxi Sum + Hashtable
// class Solution {
// public:
//     int minOperations(vector<int>& nums, int x) {
//         const int n = nums.size();
//         vector<int> l(n), r(n);
//         unordered_map<int, int> ml, mr;
//         ml[0] = mr[0] = -1;
//         for (int i = 0; i < n; ++i) {
//             l[i] = nums[i] + (i > 0 ? l[i - 1] : 0);
//             r[i] = nums[n - i - 1] + (i > 0 ? r[i - 1] : 0);
//             ml[l[i]] = mr[r[i]] = i;
//         }
//         int ans = INT_MAX;
//         for (int i = 0; i < n; ++i) {
//             int s1 = x - l[i];
//             auto it1 = mr.find(s1);
//             if (it1 != mr.end()) ans = min(ans, i + 1 + it1->second + 1);
//             int s2 = x - r[i];
//             auto it2 = ml.find(s2);
//             if (it2 != ml.end()) ans = min(ans, i + 1 + it2->second + 1);
//         }
//         return ans > n ? -1 : ans;
//     }
// };

// Solution 2: Sliding Window
class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        const int n = nums.size();
        int target = accumulate(begin(nums), end(nums), 0) - x;
        int ans = INT_MAX;
        for (int s = 0, l = 0, r = 0; r < n; ++r) {
            s += nums[r];
            while (s > target && l <= r) s -= nums[l++];
            if (s == target) ans = min(ans, n - (r - l + 1));
        }
        return ans > n ? -1 : ans;
    }
};
