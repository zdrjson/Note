// // Solution 1: Convert to string (cheating)
// // Time complexity: O(log10(x))
// // Space complexity: O(log10(x))
// class Solution {
// public:
//     bool isPalindrome(int x) {
//         string s = to_string(x);
//         return s == string(rbegin(s), rend(s));
//     }
// };

// 报错：runtime error: -inf is outside the range of representable values of type 'int' (solution.cpp)
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        int d = static_cast<int>(log10(x) + 1);
        int t = pow(10, d - 1);
        for (int i = 0; i < d / 2; ++i) {
            if (x / t != x % 10) return false;
            x = (x - x / t * t) / 10;
            t /= 100;
        }
        return true;
    }
};
