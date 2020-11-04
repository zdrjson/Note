// // Solution 0: DFS
// // TLE
// class Solution {
// public:
//     int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
//         const int n = heights.size();
//         vector<int> diffs(n);
//         for (int i = 1; i < n; ++i)
//             diffs[i - 1] = max(0, heights[i] - heights[i - 1]);
//         int ans = 0;
//         function<void(int, int, int)> dfs = [&](int s, int b, int l) {
//             if (ans == n - 1) return;
//             if (s == n - 1) {
//                 ans = n - 1;
//                 return;
//             }
//             for (int i = s; i < n; ++i) {
//                 ans = max(ans, i);
//                 if (diffs[i] == 0) continue;
//                 if (b >= diffs[i]) dfs(i + 1, b - diffs[i], l);
//                 if (l) dfs(i + 1, b, l - 1);
//                 break;
//             }
//         };
//         dfs(0, bricks, ladders);
//         return ans;
//     }
// };

// // Solution 1: Binary Search + Greedy
// class Solution {
// public: 
//     int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
//         const int n = heights.size();
//         if (ladders >= n - 1) return n - 1;
//         vector<int> diffs(n);
//         for (int i = 1; i < n; ++i)
//             diffs[i - 1] = max(0, heights[i] - heights[i - 1]);
//         int l = ladders;
//         int r = n;
//         while (l < r) {
//             int m = l + (r - l) / 2;
//             vector<int> d(begin(diffs), begin(diffs) + m);
//             nth_element(begin(d), end(d) - ladders, end(d));
//             if (accumulate(begin(d), end(d) - ladders, 0) > bricks)
//                 r = m;
//             else
//                 l = m + 1;
//         }
//         return l - 1;
//     }; 
// };

// Solution: Min heap
class Solution {
public:
    int furthestBuilding(vector<int>& heights, int bricks, int ladders) {
        const int n = heights.size();
        priority_queue<int, vector<int>, greater<int>> q;
        for (int i = 1; i < n; ++i) {
            const int d = heights[i] - heights[i - 1];
            if (d <= 0) continue;
            q.push(d);
            if (q.size() <= ladders) continue;
            bricks -= q.top(); q.pop();
            if (bricks < 0) return i - 1;
        }
        return n - 1;
    }
};
