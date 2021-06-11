// // Solution1: Liner Scan
// // Time complexity: O(n)
// // Space complexity: O(1)
// class Solution {
// public:
//     int peakIndexInMountainArray(vector<int>& A) {
//         for (int i = 1; i < A.size(); ++i)
//             if (A[i] < A[i - 1]) return i - 1;
//         return -1; // 自己加的，不加编译不过。花花代码里面没有加。
//     }
// };

// // Solution1: Liner Scan
// // STL
// class Solution {
// public:
//     int peakIndexInMountainArray(vector<int>& A) {
//         return max_element(begin(A), end(A)) - begin(A);
//     }
// };

// Solution 2: Binary Search
// Find the smallest l such that A[l] > A[l + 1].
// Time complexity: O(logn)
// Space complexity: O(1)
class Solution {
public:
    int peakIndexInMountainArray(vector<int>& A) {
        int l = 0;
        int r = A.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (A[m] > A[m + 1]) 
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
};
