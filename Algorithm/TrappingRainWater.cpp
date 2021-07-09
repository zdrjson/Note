// // Solution 1: Brute Force
// // Time complexity: O(n)
// // Space complexity: O(1)
// class Solution {
// public:
//   int trap(vector<int>& height) {
//     const int n = height.size();
//     int ans = 0;
//     auto sit = cbegin(height);
//     auto eit = cend(height);
//     for (int i = 0; i < n; ++i) {
//       int l = *max_element(sit, sit + i + 1);
//       int r = *max_element(sit + i, eit);
//       ans += min(l, r) - height[i];
//     }
//     return ans;
//   }
// };

// // Solution 2: DP
// // Time complexity: O(n)
// // Space complexity: O(1)
// class Solution {
// public:
//     int trap(vector<int>& height) {
//         const int n = height.size();
//         vector<int> l(n);
//         vector<int> r(n);
//         int ans = 0;
//         for (int i = 0; i < n; ++i)
//             l[i] = i == 0 ? height[i] : max(l[i - 1], height[i]);
//         for (int i = n - 1; i >= 0; --i)
//             r[i] = i == n - 1 ? height[i] : max(r[i + 1], height[i]);
//         for (int i = 0; i < n; ++i)
//             ans += min(l[i], r[i]) - height[i];
//         return ans;
//     }
// };

// Solution 3: Two Pointers
class Solution {
public:
    int trap(vector<int>& height) {
        const int n = height.size();
        if (n == 0) return 0;
        int l = 0;
        int r = n - 1;
        int max_l = height[l];
        int max_r = height[r];
        int ans = 0;
        while (l < r) {
            if (max_l < max_r) {
                ans += max_l - height[l];
                max_l = max(max_l, height[++l]);
            } else {
                ans += max_r - height[r];
                max_r = max(max_r, height[--r]);
            }
        }
        return ans;
    }
};
