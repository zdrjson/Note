// Find the smallest l such that A[l] > A[l + 1]
// Time complexity: O(logn)
// Space complextiy: O(1)
// 这个方法对应C++的upper_bound。
class Solution {
    public int peakIndexInMountainArray(int[] A) { 
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (A[m] > A[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

// Liner Scan 
// Time complexity: O(n)
// Space complexity: O(1)
// class Solution {
//     public int peakIndexInMountainArray(int[] A) {
//         int max = Integer.MIN_VALUE;
//         int ans = 0;
//         for (int i = 0; i < A.length; ++i)
//             if (A[i] > max) {
//                 max = A[i];
//                 ans = i;   
//             }
//         return ans;
//     }
// }

// // Liner Scan
// // Time complexity: O(n)
// // Space complexity: O(1)
// class Solution {
//     public int peakIndexInMountainArray(int[] A) {
//         for (int i = 1; i < A.length; ++i)
//             if (A[i] < A[i - 1]) return i - 1;
//         return 0; 
//     }
// }
