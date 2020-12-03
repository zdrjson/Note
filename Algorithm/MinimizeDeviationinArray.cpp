// // Solution: Set
// class Solution {
// public:
//     int minimumDeviation(vector<int>& nums) {
//         set<int> s;
//         for (int x : nums)
//             s.insert(x & 1 ? x * 2 : x);
//         int ans = *rbegin(s) - *begin(s);
//         while (*rbegin(s) % 2 == 0) {
//             s.insert(*rbegin(s) / 2);
//             s.erase(*rbegin(s));
//             ans = min(ans, *rbegin(s) - *begin(s));
//         }
//         return ans;
//     }
// };

// PriorityQueue
class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        priority_queue<int> q;
        int lo = INT_MAX;
        for (int x : nums) {
            x = x & 1 ? x * 2 : x;
            q.push(x);
            lo = min(lo, x);
        }
        int ans = q.top() - lo;
        while (q.top() % 2 == 0) {
            int x = q.top(); q.pop();
            q.push(x / 2);
            lo = min(lo, x / 2);
            ans = min(ans, q.top() - lo);
        }
        return ans;
    }
};
