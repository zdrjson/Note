// Solution 3: Two Pointers
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int trap(int[] height) {
        final int n = height.length;
        if (n == 0) return 0;
        int l = 0;
        int r = n - 1;
        int max_l = height[l];
        int max_r = height[n - 1];
        int ans = 0;
        while (l < r) {
            if (max_l < max_r) {
                ans += max_l - height[l];
                max_l = Math.max(max_l, height[++l]);
            } else {
                ans += max_r - height[r];
                max_r = Math.max(max_r, height[--r]);
            }
        }
        return ans;
    }
}

// // Solution 2: DP 
// // Time complexity: O(n)
// // Space complexity: O(1)
// class Solution {
//     public int trap(int[] height) {
//         final int n = height.length;
//         int[] l = new int[n];
//         int[] r = new int[n];
//         int ans = 0;
//         for (int i = 0; i < n; ++i) 
//             l[i] = i == 0  ? height[i] : Math.max(l[i - 1], height[i]);
//         for (int i = n - 1; i >= 0; --i) 
//             r[i] = i == n - 1 ? height[i] : Math.max(r[i + 1], height[i]);
//         for (int i = 0; i < n; ++i) 
//             ans += Math.min(l[i], r[i]) - height[i];
//         return ans;
//     }
// }

// // Solution 1: Brute Force 
// // Time complexity: O(n^2)
// // Space complexity: O(n)
// class Solution {
//     public int trap(int[] height) {
//         final int n = height.length;
//         int ans = 0;
//         for (int i = 0; i < n; ++i) {
//             int l = 0;
//             for (int x = 0; x < i + 1; ++x) 
//                 if (height[x] > l) l = height[x];
//             int r = 0;
//             for (int y = i; y < n; ++y) 
//                 if (height[y] > r) r = height[y];
//             ans += Math.min(l, r) - height[i];    // (Math.min(l, r) - height[i])必须要比0大
//         }
//         return ans;
//     }
// }
