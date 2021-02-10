// // Solution 1: Greedy
// class Solution {
// public:
//     int maximumScore(int a, int b, int c) {
//         array<int, 3> s{a, b, c};
//         sort(begin(s), end(s));
//         int ans = 0;
//         while (s[1]-- && s[2]--) {
//             ++ans;
//             sort(begin(s), end(s));
//         }
//         return ans;
//     }
// };

// Solution 2: Math
class Solution {
public:
    int maximumScore(int a, int b, int c) {
        array<int, 3> s{a, b, c};
        sort(begin(s), end(s));
        return (s[0] + s[1] + min(s[0] + s[1], s[2])) / 2;
    }
};
